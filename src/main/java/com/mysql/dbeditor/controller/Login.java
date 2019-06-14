package com.mysql.dbeditor.controller;

import com.mysql.dbeditor.entity.User;
import com.mysql.dbeditor.repository.ServerInfoRepository;
import com.mysql.dbeditor.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class Login {
    private UserRepository userRepository = new UserRepository();
    private ServerInfoRepository serverInfoRepository = new ServerInfoRepository();
    @GetMapping("login")
    public ModelAndView loginPage(ModelAndView modelAndView, HttpSession session){
        if(session.getAttribute("currentUser") == null)
            modelAndView.setViewName("login.html");
        else
            modelAndView.setViewName("redirect:/index") ;
        return modelAndView;
    }
    @PostMapping("loginPost")
    public ModelAndView login(ModelAndView modelAndView, HttpServletRequest request, HttpSession session){
        User user = userRepository.findByEmailAndPassword(request.getParameter("email"), request.getParameter("password"));
        session.setAttribute("currentUser", user);
        if(user != null)
            if(serverInfoRepository.findByUserId(user.getId()) != null)
                modelAndView.setViewName("redirect:/index");
            else
                modelAndView.setViewName("Burası sonradan yaplandırılacak");
        else
            modelAndView.setViewName("redirect:/login");
        return modelAndView;
    }
}
