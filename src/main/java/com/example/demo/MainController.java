package com.example.demo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class MainController {
    @RequestMapping("/")
    public String WeatherInfoApp(Model model) {
       
        return "WeatherInfoApp"; //maps to WeatherInfoApp.html
    }
   



}