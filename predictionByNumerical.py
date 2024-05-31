import pandas as pd 
import numpy as np
import matplotlib.pyplot as plt
import warnings
warnings.filterwarnings("ignore")
import seaborn as sns
from sklearn.model_selection import train_test_split
from sklearn.preprocessing import StandardScaler, LabelEncoder

df = pd.read_csv("strokeData.csv")

# id column 없애기 + 기혼여부 수치로 바꾸기.
df = df.drop("number",axis=1)
df = df.drop("id",axis=1)
df['ever_married'] = df['ever_married'].map({'Yes':1, 'No':0})

# gender의 other 없애기
df = df[df['gender'] != 'Other']

# 범주형 데이터 인코딩
categorical_cols = ['gender', 'work_type', 'residence_type', 'smoking_status']
for col in categorical_cols:
    le = LabelEncoder()
    df[col] = le.fit_transform(df[col])

x = df.drop("stroke",axis=1)
y = df.stroke

from imblearn.over_sampling import SMOTE
smote = SMOTE(sampling_strategy="minority")
x_smote, y_smote = smote.fit_resample(x, y)               
y_smote.value_counts()

x_train, x_test, y_train, y_test = train_test_split(x_smote, y_smote, test_size=0.2, random_state=42, stratify=y_smote)
scaler = StandardScaler()
x_train = scaler.fit_transform(x_train)
x_test = scaler.transform(x_test)  

# 모델 학습 및 평가
from lazypredict.Supervised import LazyClassifier
clf = LazyClassifier(verbose=0, ignore_warnings=True, custom_metric=None)
models, predictions = clf.fit(x_train, x_test, y_train, y_test)
print(models)


from sklearn.ensemble import RandomForestClassifier
'''
rf = RandomForestClassifier()
rf.fit(x_train, y_train)

# 성능 평가
from sklearn.metrics import accuracy_score, precision_score, recall_score, confusion_matrix, ConfusionMatrixDisplay

y_pred = rf.predict(x_test)
accuracy = accuracy_score(y_test, y_pred)
print("Accuracy:", accuracy)

# 혼동 행렬 시각화
cm = confusion_matrix(y_test, y_pred)
disp = ConfusionMatrixDisplay(confusion_matrix=cm)
disp.plot()
plt.show()
'''

from sklearn.metrics import accuracy_score, confusion_matrix, ConfusionMatrixDisplay

# RandomForest 모델을 학습시킵니다.
rf = RandomForestClassifier()
rf.fit(x_train, y_train)

# 예측 확률을 계산합니다.
y_pred_proba = rf.predict_proba(x_test)[:, 1]  # 뇌졸중 클래스('1')에 대한 확률 추출
print("Predicted probabilities for having a stroke:", y_pred_proba)

# 임계값 설정을 기반으로 예측 결과를 계산합니다 (예: 확률 > 0.5면 뇌졸중으로 예측)
threshold = 0.5
y_pred = (y_pred_proba >= threshold).astype(int)

# 정확도 계산
accuracy = accuracy_score(y_test, y_pred)
print("Accuracy:", accuracy)

'''
# 혼동 행렬 시각화
cm = confusion_matrix(y_test, y_pred)
disp = ConfusionMatrixDisplay(confusion_matrix=cm)
disp.plot()
plt.show()
'''

# 모델 저장
from joblib import dump, load
dump(rf, 'stroke_model.pkl')
