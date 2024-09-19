package com.armasDS.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class ControllerHome {

    @GetMapping
    public ModelAndView verInicio() {
        return new ModelAndView("home");
    }
}
