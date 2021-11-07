package com.example.nutry.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@CrossOrigin(origins="${crossorigin}")
public class ResultController {
    @Value("${api.key}")
    private String apiKey;

//    @Autowired
//    private RestTemplate restTemplate;

    @RequestMapping("/search/{searchWord}")
    public String getSearchResult(@PathVariable("searchWord") String searchWord) {
        String uri = "https://api.nal.usda.gov/fdc/v1/foods/search?api_key="+apiKey+"&query="+searchWord+"&dataType=Survey (FNDDS)";
        RestTemplate rt = new RestTemplate();
        String result = rt.getForObject(uri, String.class);
        return result;
    }

}
