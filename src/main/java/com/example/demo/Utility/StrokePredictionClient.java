package com.example.demo.Utility;//건들지 마쇼
import com.example.demo.DTO.UserInfo;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.File;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class StrokePredictionClient {
    public double strokePredictionClient() throws IOException {
        try (CloseableHttpClient client = HttpClients.createDefault()) {
            //api 주소
            HttpPost request = new HttpPost("http://localhost:5000/predict");
            Gson gson = new Gson();
            ObjectMapper objectMapper = new ObjectMapper();
            // JSON 파일을 Person 객체로 변환
            UserInfo userInfo = objectMapper.readValue(new File("Repository/userInfo.json"), UserInfo.class);

            //api에 넘겨줄 정보, userinfo를 가공해서 넣어야 함.
            //입력 순서: ["gender", "age", "hypertension", "heart_disease", "ever_married", "work_type", "residence_type",
            //"avg_glucose_level", "bmi", "smoking_status"]

            String json = "{"
                    + "\"gender\": " + userInfo.getGender() + ","              // 0 : Female | 1 : Male
                    + "\"age\": " + userInfo.getAge() + ","
                    + "\"hypertension\": " + userInfo.getHypertension() + ","
                    + "\"heart_disease\": " + userInfo.getHeartdisease() + ","
                    + "\"ever_married\": " + userInfo.getEverMarried() + ","        // 1: Yes | 0: NO
                    + "\"work_type\": " + userInfo.getWorkType() + ","           // 0 : Govt_job | 1: Private | 2: Self_employed | 3: Children
                    + "\"residence_type\": " + userInfo.getResidenceType() + ","      // 0: Rural | 1: Urban
                    + "\"avg_glucose_level\": " + userInfo.getAvgGlucoseLevel() + ","
                    + "\"bmi\": " + userInfo.getBmi() + ","
                    + "\"smoking_status\": " + userInfo.getSmokingStatus()       // 0: Unknown | 1: fomerly smoked | 2: never smoked | 3: smokes
                    + "}";

            StringEntity entity = new StringEntity(json, "UTF-8");
            request.setEntity(entity);
            request.setHeader("Accept", "application/json");
            request.setHeader("Content-type", "application/json");

            CloseableHttpResponse response = client.execute(request);

            // 검사 결과
            String result = EntityUtils.toString(response.getEntity());

            Pattern pattern = Pattern.compile("\\d+\\.\\d+");
            Matcher matcher = pattern.matcher(result);

            if (matcher.find()) {
                String number = matcher.group();
                double resultNum = Double.parseDouble(number);
                userInfo.setStrokePercent(resultNum);
                return resultNum;
            } else {
                System.out.println("No match found");
            }
        }
        return 0;
    }
}