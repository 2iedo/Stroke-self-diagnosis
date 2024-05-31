import numpy as np
import joblib

# 예시 입력 데이터 (임의 값)
input_data = {
    "gender": 1,  # 예: 'Male'을 1로 인코딩
    "age": 83,
    "hypertension": 1,
    "heart_disease": 1,
    "ever_married": 1,  # 예: 'Yes'를 1로 인코딩
    "work_type": 1,  # 예: 'Self-employed'를 2로 인코딩
    "residence_type": 0,  # 예: 'Urban'을 0으로 인코딩
    "avg_glucose_level": 248.1,
    "bmi": 38.1,
    "smoking_status": 3 # 예: 'formerly smoked'를 1로 인코딩
}

# 입력 데이터를 모델에 맞는 형태로 변환
input_features = np.array([[input_data[feature] for feature in input_data]])

# 모델 로드
model = joblib.load('stroke_model.pkl')

# 예측 확률 계산
predicted_probabilities = model.predict_proba(input_features)[:, 1]  # 뇌졸중 클래스('1')의 확률
print("Predicted probability of having a stroke:", predicted_probabilities[0])
