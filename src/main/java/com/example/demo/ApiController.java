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
// This API controller class handles the search functionality
    @PostMapping("/search")
    public ResponseEntity<List<WeatherInfoData>> search(@RequestBody Map<String, String> request) {
        WeatherServiceImpl WeatherServiceImplObj=new WeatherServiceImpl();
        List<WeatherInfoData> results;
        String city = request.get("city");
        
        //First we try to find if data is available in memory (in this case we are using arraylist to store data in memory)
        WeatherInfoData weatherInfoDataObj=WeatherServiceImpl.checkInMemory(city);
        
        if(weatherInfoDataObj.getResponseCode().equals("1"))
        {
           results = List.of(weatherInfoDataObj);
            //This means data found in memory - arraylist
        }
        else
        {
            WeatherInfoData WeatherInfoDataObj= WeatherServiceImplObj.searchWeatherInfoFromMockData(city);
            results = List.of(WeatherInfoDataObj); 
           //This means data need to search through API, for this assessment we have used json mock data
        }
       
        return ResponseEntity.ok(results);
    }
    
}
