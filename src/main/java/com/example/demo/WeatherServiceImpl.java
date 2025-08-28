package com.example.demo;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.core.io.ClassPathResource;

public class WeatherServiceImpl {

    public  static List<WeatherInfoData> weatherList = new ArrayList<>() ;
    
    public static WeatherInfoData checkInMemory(String city)
    {
       
        for (WeatherInfoData weatherInfoData : weatherList) {
            
            if(weatherInfoData.getCity().equalsIgnoreCase(city))
            {
                
                return weatherInfoData;
            }
            
        }
        WeatherInfoData weatherInfoData = new WeatherInfoData();
        weatherInfoData.setResponseCode("0");
        return weatherInfoData;
    }

    public WeatherInfoData searchWeatherInfoFromMockData (String city)
    {
        WeatherInfoData WeatherInfoDataObj=null;
        ObjectMapper mapper = new ObjectMapper();
       try{
              /*   List<WeatherInfoData> weatherListLocalObj = mapper.readValue(
                new File("C:\\Learnings\\Java\\Program\\WeatherApp\\demo\\src\\main\\resources\\static\\data\\NZ_WeatherData.json"),
                new TypeReference<ArrayList<WeatherInfoData>>() {}
            ).stream().filter(info -> city.equalsIgnoreCase(info.getCity())).collect(Collectors.toList())
;*/


            List<WeatherInfoData> weatherListLocalObj = mapper.readValue(
                new ClassPathResource("static/data/NZ_WeatherData.json").getInputStream(),
                new TypeReference<ArrayList<WeatherInfoData>>() {}
            ).stream()
            .filter(info -> city.equalsIgnoreCase(info.getCity()))
            .collect(Collectors.toList());

            if (weatherListLocalObj.size()!=0)
            {
                
                WeatherInfoDataObj=weatherListLocalObj.get(0);
                WeatherInfoDataObj.setResponseCode("1");
                
                weatherList.add(WeatherInfoDataObj);
            }
            else
            {
                WeatherInfoDataObj=new WeatherInfoData("NOT FOUND",  "-",  "-",  "-",  "-", "0");
               
            }
            
        }
        catch(Exception e)
        {
            System.out.println("Exception occurred with detail message::"+e.getMessage());
        }
        return WeatherInfoDataObj;
    }

}