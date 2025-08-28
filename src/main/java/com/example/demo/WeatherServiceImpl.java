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
     //This method searches weather data in memory , we are using arraylist here for in memory data
        for (WeatherInfoData weatherInfoData : weatherList) {
            
            if(weatherInfoData.getCity().equalsIgnoreCase(city))
            {
                //This means data found in arraylist
                return weatherInfoData;
            }
            
        }
        WeatherInfoData weatherInfoData = new WeatherInfoData();
        weatherInfoData.setResponseCode("0"); // This means data not found in arralist
        return weatherInfoData;
    }

    public WeatherInfoData searchWeatherInfoFromMockData (String city)
    {
        //This method searches data from API, as part of this assessment we are using json mock data
        WeatherInfoData WeatherInfoDataObj=null;
        ObjectMapper mapper = new ObjectMapper();
       try{
           //Read Json file and try to search data for given city name  
            List<WeatherInfoData> weatherListLocalObj = mapper.readValue(
                new ClassPathResource("static/data/NZ_WeatherData.json").getInputStream(),
                new TypeReference<ArrayList<WeatherInfoData>>() {}
            ).stream()
            .filter(info -> city.equalsIgnoreCase(info.getCity()))
            .collect(Collectors.toList());

            if (weatherListLocalObj.size()!=0)
            {
                //This means data found in mock JSON file
                WeatherInfoDataObj=weatherListLocalObj.get(0);
                WeatherInfoDataObj.setResponseCode("1");
                //Add weather data to memory
                weatherList.add(WeatherInfoDataObj);
            }
            else
            {
                WeatherInfoDataObj=new WeatherInfoData("NOT FOUND",  "-",  "-",  "-",  "-", "0");
               //This means data not available / not found in mock JSON - This include invalid entry as well
            }
            
        }
        catch(Exception e)
        {
            System.out.println("Exception occurred with detailed message::"+e.getMessage());
        }
        return WeatherInfoDataObj;
    }

}