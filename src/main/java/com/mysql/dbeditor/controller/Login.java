package com.mysql.dbeditor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class Login {
    @GetMapping("login")
    public ModelAndView loginPage(ModelAndView modelAndView){
        modelAndView.setViewName("login.html");
        return modelAndView;
    }
    @PostMapping("login")
    public ModelAndView login(ModelAndView modelAndView, HttpServletRequest request){
        System.out.println(request.getParameter("email"));
        System.out.println(request.getParameter("password"));
        modelAndView.setViewName("index.html");
        return modelAndView;
    }
}
