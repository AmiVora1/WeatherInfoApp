package com.example.demo;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class WeatherServiceImplTests {

    private final WeatherServiceImpl service = new WeatherServiceImpl();

    @Test
    public void testServiceMethodWhenDataNotAvailableInMemory() {
        WeatherInfoData weatherInfoData = WeatherServiceImpl.checkInMemory("Nelson");
        assertEquals("0", weatherInfoData.getResponseCode());
    }
     @Test
    public void testServiceMethodWhenDataAvailableInMemory() {
        WeatherInfoData weatherInfoData=service.searchWeatherInfoFromMockData("Auckland");
         weatherInfoData = WeatherServiceImpl.checkInMemory("Auckland");
        assertEquals("1", weatherInfoData.getResponseCode());
    }
    @Test
    public void testServiceMethodWhenDataAvailableFromMockAPI(){
        WeatherInfoData weatherInfoData=service.searchWeatherInfoFromMockData("Wellington");
        assertEquals("1", weatherInfoData.getResponseCode());
    }
    @Test
    public void testServiceMethodWhenDataNotAvailableFromMockAPI(){
        WeatherInfoData weatherInfoData=service.searchWeatherInfoFromMockData("blahblah");
        assertEquals("0", weatherInfoData.getResponseCode());
    }
     @Test
    public void testServiceMethodWhenDataAvailableFromMockAPIByIgnoreCase(){
        WeatherInfoData weatherInfoData=service.searchWeatherInfoFromMockData("hamilTON");
        assertEquals("1", weatherInfoData.getResponseCode());
    }
}

