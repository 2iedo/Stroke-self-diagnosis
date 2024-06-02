package com.example.demo.Utility;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/DecisionStroke")
public class DecisionStroke {

    @CrossOrigin(origins = "http://localhost:1234")
    @GetMapping
    public double startDecision(){
        StrokePredictionClient client = new StrokePredictionClient();
        try{
            Double strokePercent = client.strokePredictionClient();
            return strokePercent;
        }
        catch(Exception e){return 0;}
    }
}
