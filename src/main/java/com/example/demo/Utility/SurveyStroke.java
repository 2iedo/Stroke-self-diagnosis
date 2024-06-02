package com.example.demo.Utility;

import com.example.demo.DTO.UserInfo;
import org.springframework.web.bind.annotation.*;
import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;

@RestController
@RequestMapping("/api/SurveyStroke")

public class SurveyStroke {
    private UserInfo userInfo;
    @CrossOrigin(origins = "http://localhost:1234")
    @PostMapping
    public void startSurvey(@RequestBody UserInfo data) {
        // Gson 인스턴스 생성
        System.out.println(data);
        Gson gson = new Gson();

        // 자바 객체를 JSON 문자열로 변환
        String jsonString = gson.toJson(data);

        // 자바 객체를 JSON 파일로 변환
        try (FileWriter writer = new FileWriter("Repository/userInfo.json")) {
            gson.toJson(data, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
