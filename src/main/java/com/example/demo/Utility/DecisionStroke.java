package com.example.demo.Utility;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
@RequestMapping("/api/DecisionStroke")
public class DecisionStroke {

    @CrossOrigin(origins = "http://localhost:1234", methods = {RequestMethod.GET})    @GetMapping
    public double startDecision(){
        StrokePredictionClient client = new StrokePredictionClient();
        try{
            double strokePercent = client.strokePredictionClient();
            return strokePercent;
        }
        catch(Exception e){return 1;}
    }
}
