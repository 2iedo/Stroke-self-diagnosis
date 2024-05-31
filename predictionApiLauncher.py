from flask import Flask, request, jsonify
import joblib
import numpy as np

app = Flask(__name__)

# 모델 로드
model = joblib.load('stroke_model.pkl')

@app.route('/predict', methods=['POST'])
@app.route('/predict', methods=['POST'])
def predict():
    data = request.get_json()
    input_data = np.array([[data[field] for field in data]])
    prediction = model.predict(input_data) #뇌졸중 여부 (데이터 기반)
    prediction_proba = model.predict_proba(input_data)[:, 1]  # 뇌졸중 확률
    return jsonify({'prediction': prediction.tolist(), 'probability': prediction_proba.tolist()})


if __name__ == '__main__':
    app.run(debug=True, host='0.0.0.0', port=5000)
