package com.mysql.dbeditor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Table {

    @GetMapping("table")
    public ModelAndView table(ModelAndView modelAndView){
        modelAndView.setViewName("tables.jsp");
        return modelAndView;
    }
}
