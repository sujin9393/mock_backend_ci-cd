package com.hellomello.mock_backend.controller;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
@RestController
public class HelloController {
    @Value("${fastapi.base.url}")
    private String fastapiBaseUrl;
    
    @GetMapping("/api/hello")
    public String hello() {
        RestTemplate restTemplate = new RestTemplate();
        String fastapiUrl = fastapiBaseUrl + "ai/hello";
        try {
            String fastapiResponse = restTemplate.getForObject(fastapiUrl, String.class);
            return "Spring → " + fastapiResponse;
        } catch (Exception e) {
            return "Spring → FastAPI 연결 실패: " + e.getMessage();
        }
    }
}
