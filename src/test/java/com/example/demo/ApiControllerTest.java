package com.example.demo;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;

import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;



@ExtendWith(SpringExtension.class)
@WebMvcTest(ApiController.class)
class ApiControllerTest {

   
    @MockBean
    private ApiController apiController;

    @Test
    void testSearchWeather() throws Exception {
        // Arrange: mock data
        Map<String, String> requestMap = Map.of("city", "Wellington");
        List<WeatherInfoData> mockResponse = List.of(
            new WeatherInfoData("Wellington", "16", "2025-08-28","°C","Cloudy","1" ) 
        );

        // Mock service behavior
        Mockito.when(apiController.search(requestMap)).thenReturn(ResponseEntity.ok(mockResponse));

    }
}