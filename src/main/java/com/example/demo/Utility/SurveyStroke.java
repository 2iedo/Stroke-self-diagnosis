package com.example.demo.Utility;

import com.example.demo.DTO.UserInfo;
import java.util.ArrayList;

public class SurveyStroke {
    private UserInfo userInfo;
    public UserInfo startSurvey(){
        ArrayList<String> labelScore = new ArrayList<>();


        //front에서 받아오는 작업


        return userInfo;
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
