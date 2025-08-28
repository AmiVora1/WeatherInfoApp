package com.example.demo;

import org.springframework.web.bind.annotation.RestController;
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
    public ResponseEntity<List<WeatherInfoData>> search(@RequestBody Map<String, String> request) {
        WeatherServiceImpl WeatherServiceImplObj=new WeatherServiceImpl();
        List<WeatherInfoData> results;

        String city = request.get("city");
        
        WeatherInfoData weatherInfoDataObj=WeatherServiceImpl.checkInMemory(city);
        
        if(weatherInfoDataObj.getResponseCode().equals("1"))
        {
           results = List.of(weatherInfoDataObj);

        }
        else
        {
            WeatherInfoData WeatherInfoDataObj= WeatherServiceImplObj.searchWeatherInfoFromMockData(city);
            results = List.of(WeatherInfoDataObj); 
           
        }
       
        return ResponseEntity.ok(results);
    }
    
}
