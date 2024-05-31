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
#인코딩된 데이터 확인용
from sklearn.preprocessing import LabelEncoder

# 예시 데이터
data = {
    'residence_type': ['Urban', 'Rural', 'Urban', 'Rural'],
    'gender' : ['Male', 'Female', 'Male', 'Female'],
    'work_type' : ['Private', 'Govt_job', 'Self_employed', 'children'],
    'smoking_status' : ['smokes', 'never smoked', 'formerly smoked', 'Unknown']
}

df = pd.DataFrame(data)

# LabelEncoder 객체 생성 및 학습
encoder = LabelEncoder()
df['residence_type_encoded'] = encoder.fit_transform(df['residence_type'])
df['gender_encoded'] = encoder.fit_transform(df['gender'])
df['work_type_encoded'] = encoder.fit_transform(df['work_type'])
df['smoking_status_encoded'] = encoder.fit_transform(df['smoking_status'])

# 인코딩 결과 확인
print(df)

# 범주가 어떻게 인코딩되었는지 확인
classes = encoder.classes_
print("Classes:", classes)

# "Urban"이 인코딩된 값 찾기
urban_index = encoder.transform(['Urban'])[0]
gender_index = encoder.transform(['Male'])[0]
#work_index = encoder.transform([''])
'''

# 모델 저장
from joblib import dump, load
dump(rf, 'stroke_model.pkl')
