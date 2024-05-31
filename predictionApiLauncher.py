from flask import Flask, request, jsonify
import joblib
import numpy as np

app = Flask(__name__)

# 모델 로드
model = joblib.load('stroke_model.pkl')

@app.route('/predict', methods=['POST'])
def predict():
    data = request.get_json()
    # JSON 데이터를 모델 입력 배열로 변환
    # 입력 순서: ["gender", "age", "hypertension", "heart_disease", "ever_married", "work_type", "residence_type", 
    # "avg_glucose_level", "bmi", "smoking_status"]
    input_data = np.array([[data["gender"], data["age"], data["hypertension"], data["heart_disease"],
                            data["ever_married"], data["work_type"], data["residence_type"],
                            data["avg_glucose_level"], data["bmi"], data["smoking_status"]]])
    
    # 예측 실행
    prediction = model.predict(input_data)
    # 예측 결과를 JSON 형식으로 반환
    return jsonify({'prediction': prediction.tolist()})

if __name__ == '__main__':
    app.run(debug=True, host='0.0.0.0', port=5000)
