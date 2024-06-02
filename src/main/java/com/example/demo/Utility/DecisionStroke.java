package com.example.demo.Utility;

import com.example.demo.DTO.UserInfo;
import com.google.gson.Gson;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/DecisionStroke")
public class DecisionStroke {

    @CrossOrigin(origins = "http://localhost:1234")
    @GetMapping
    public String startDecision(){
        Gson gson = new Gson();
        UserInfo userInfo = null; // 이부분 읽어 오기
        String userInfoJson = gson.toJson(userInfo.getStrokePercent());
        return userInfoJson;
    }

    public void updateResult(){

    }
}
