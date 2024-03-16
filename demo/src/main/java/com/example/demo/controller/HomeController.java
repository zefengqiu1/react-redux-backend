package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
//https://medium.com/@irfan.shaekh/install-docker-and-docker-compose-centos-7-9fc4223795d
@Controller
public class HomeController {

    @RequestMapping(value = "/")
    public String index() {
        return "index.html";
    }

    @RequestMapping(value = "/experiences/new")
    public ModelAndView redirect() {
        return new ModelAndView("forward:/");
    }

    @RequestMapping(value = "/experiences")
    public ModelAndView redirect1() {
        return new ModelAndView("forward:/");
    }

    @RequestMapping(value = "/experiences/{id}")
    public ModelAndView redirect2() {
        return new ModelAndView("forward:/");
    }
}
