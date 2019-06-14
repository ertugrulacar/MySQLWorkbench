package com.mysql.dbeditor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Index {
    @GetMapping("index")
    public ModelAndView modelAndView(ModelAndView modelAndView){
        modelAndView.setViewName("index.html");
        return modelAndView;
    }
}
