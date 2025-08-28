package com.example.demo;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class WeatherServiceImpl {

    public  static List<WeatherInfoData> weatherList = new ArrayList<>() ;
    
    public static WeatherInfoData checkInMemory(String city)
    {
       System.out.println("Checking in memory for city::"+city);
        for (WeatherInfoData weatherInfoData : weatherList) {
            System.out.println("Inside for loop");
            if(weatherInfoData.getCity().equalsIgnoreCase(city))
            {
                System.out.println("Found city data::");
                return weatherInfoData;
            }
            
        }
        return null;
    }

    public WeatherInfoData searchWeatherInfoFromMockData (String city)
    {
        WeatherInfoData WeatherInfoDataObj=null;
        ObjectMapper mapper = new ObjectMapper();
       try{
       List<WeatherInfoData> weatherListLocalObj = mapper.readValue(
                new File("C:\\Learnings\\Java\\Program\\WeatherApp\\demo\\src\\main\\resources\\static\\data\\NZ_WeatherData.json"),
                new TypeReference<ArrayList<WeatherInfoData>>() {}
            ).stream().filter(info -> city.equalsIgnoreCase(info.getCity())).collect(Collectors.toList())
;
            if (weatherListLocalObj !=null)
            {
                System.out.println("Added in memory::");
                weatherList.add(weatherListLocalObj.get(0));
                WeatherInfoDataObj=weatherListLocalObj.get(0);
                
            }
            
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        return WeatherInfoDataObj;
    }

}