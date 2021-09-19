package com.example.nutry.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ResultController {
//    @Value("${api.key}")
//    private String apiKey;

//    @Autowired
//    private RestTemplate restTemplate;

    @RequestMapping("/search")
    public String getSearchResult() {
        String uri = "https://api.nal.usda.gov/fdc/v1/food/1102682?api_key=DEMO_KEY";
        RestTemplate rt = new RestTemplate();
        String result = rt.getForObject(uri, String.class);
        System.out.println(result);
        return result;
    }

}
