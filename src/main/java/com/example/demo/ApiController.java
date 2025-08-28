package com.example.demo;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

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
    public ResponseEntity<List<WeatherInfoData>> search(@RequestBody Map<String, String> request) {
        String searchTerm = request.get("searchTerm");
       
        System.out.println(searchTerm +"found....."); 
        // Mock search logic
        WeatherServiceImpl WeatherServiceImplObj=new WeatherServiceImpl();
        WeatherInfoData weatherInfoDataObj1=WeatherServiceImpl.checkInMemory(searchTerm);
        if(weatherInfoDataObj1!=null)
        {
            System.out.println("Found in memory....."+ convertToJSON(weatherInfoDataObj1));
           
        }
        else
        {
            WeatherInfoData WeatherInfoDataObj= WeatherServiceImplObj.searchWeatherInfoFromMockData(searchTerm);
            if(WeatherInfoDataObj!=null)
            {
                System.out.println("found in mock data::"+ convertToJSON(WeatherInfoDataObj));
                 
            }
            else
            {
                System.out.println("Didn't find anywhere:::");
            }
        }
        
       
       
     //  List<String> results = List.of("city:Auckland","temp:30");

        return ResponseEntity.ok(WeatherServiceImpl.weatherList);
    }
    private String convertToJSON(WeatherInfoData WeatherInfoDataObj)
    {
        try{
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writeValueAsString(WeatherInfoDataObj);

        System.out.println(jsonString);
        return jsonString;
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        return "";
    }
}
