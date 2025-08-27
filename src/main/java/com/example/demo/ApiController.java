package com.example.demo;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
@RestController
@RequestMapping("/api")
public class ApiController {

    @PostMapping("/search")
    public ResponseEntity<List<String>> search(@RequestBody Map<String, String> request) {
        String searchTerm = request.get("searchTerm");
        System.out.println(searchTerm +"found"); 
        // Mock search logic
        List<String> results = List.of("city:Auckland","temp:30");

        return ResponseEntity.ok(results);
    }
}
