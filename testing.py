import requests
import json

# API 엔드포인트
url = 'http://localhost:5000/predict'

# API에 전달할 데이터
# 예제 데이터는 실제 모델의 입력 요구사항에 맞게 조정해야 합니다.
data = {
    "gender": 1,  # 예: 남성은 1, 여성은 0으로 인코딩된 것 가정
    "age": 13,
    "hypertension": 0,
    "heart_disease": 0,
    "ever_married": 0,
    "work_type": 3,  # 예: Private은 2로 인코딩된 것 가정
    "residence_type": 1,  # 예: Urban은 1로 인코딩된 것 가정
    "avg_glucose_level": 75.42,
    "bmi": 40.1,
    "smoking_status": 2  # 예: never smoked는 0으로 인코딩된 것 가정
}

# 데이터를 JSON 형식으로 변환
json_data = json.dumps(data)
# POST 요청을 보냄
response = requests.post(url, json=data)  # `json=data`를 사용하여 자동 인코딩


# 응답 출력
print('Status Code:', response.status_code)
print('Response:', response.json())
