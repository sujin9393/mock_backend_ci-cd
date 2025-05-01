package com.hellomello.mock_backend.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import java.util.Map;
import java.util.HashMap;
import org.springframework.http.ResponseEntity;

@RestController
public class HelloController {

    @Value("${fastapi.base.url}")
    private String fastapiBaseUrl;

    @GetMapping("/api/hello")
    public ResponseEntity<Map<String, Object>> hello() {
        RestTemplate restTemplate = new RestTemplate();
        String fastapiUrl = fastapiBaseUrl + "ai/hello";

        try {
            Map<String, Object> response = restTemplate.getForObject(fastapiUrl, Map.class);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            Map<String, Object> error = new HashMap<>();
            error.put("error", "FastAPI 연결 실패");
            error.put("detail", e.getMessage());
            return ResponseEntity.internalServerError().body(error);
        }
    }
}
