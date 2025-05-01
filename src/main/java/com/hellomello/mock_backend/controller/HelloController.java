package com.hellomello.mock_backend.controller;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import java.util.Map;
import org.springframework.http.ResponseEntity;

@RestController
public class HelloController {
    @Value("${fastapi.base.url}")
    private String fastapiBaseUrl;
    
    @GetMapping("/api/hello")
    public String hello() {
        RestTemplate restTemplate = new RestTemplate();
        String fastapiUrl = fastapiBaseUrl + "ai/hello";
        try {
            // FastAPI 응답을 Map으로 파싱
            Map response = restTemplate.getForObject(fastapiUrl, Map.class);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(Map.of("error", "FastAPI 연결 실패", "detail", e.getMessage()));
        }
    }
}
