import requests
import json

# API 엔드포인트 URL
url = 'http://localhost:5000/predict'

# 전송할 데이터: 실제 모델의 입력 요구사항에 맞춰 조정하세요.
data = {
    "gender": 1,  # 예: 'Male'을 1로 인코딩
    "age": 45,
    "hypertension": 0,
    "heart_disease": 0,
    "ever_married": 1,  # 'Yes'를 1로 인코딩
    "work_type": 2,  # 'Self-employed'를 2로 인코딩
    "residence_type": 1,  # 'Urban'을 1로 인코딩
    "avg_glucose_level": 105.3,
    "bmi": 28.1,
    "smoking_status": 2  # 'Formerly smoked'를 2로 인코딩
}

# JSON 형식으로 데이터 변환
json_data = json.dumps(data)

# POST 요청을 보내고 응답을 받음
response = requests.post(url, data=json_data, headers={'Content-Type': 'application/json'})

# 응답 출력
print('Status Code:', response.status_code)
print('Response:', response.json())
