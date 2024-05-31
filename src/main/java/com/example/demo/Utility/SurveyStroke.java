package com.example.demo.Utility;

import com.example.demo.DTO.UserInfo;
import org.springframework.web.bind.annotation.*;
import jakarta.persistence.Entity;

@RestController
@RequestMapping("/api/SurveyStroke")
public class SurveyStroke {
    private UserInfo userInfo;

    @PostMapping
    public void startSurvey(@RequestBody UserInfo data) {
        userInfo = data;
    }

    public void updateUserLabel(int score, String label){
        switch (label){
            case "gender":
                userInfo.setGender(score);
                break;
            case "age":
                userInfo.setAge(score);
                break;
            case "hypertension":
                userInfo.setHypertension(score);
                break;
            case "heartdisease":
                userInfo.setHeartdisease(score);
                break;
            case "everMarried":
                userInfo.setEverMarried(score);
                break;
            case "workType":
                userInfo.setWorkType(score);
                break;
            case "bmi":
                userInfo.setBmi((double)score);
                break;
            case "smokingStatus":
                userInfo.setSmokingStatus(score);
                break;
        }
    }
}
