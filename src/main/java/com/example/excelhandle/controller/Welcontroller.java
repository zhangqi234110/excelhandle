package com.example.excelhandle.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class Welcontroller {

    @RequestMapping(value = "/wel",method = RequestMethod.GET)
    public String wel(){
        System.out.println("ni ");
        return "excelhandle";
    }
}
