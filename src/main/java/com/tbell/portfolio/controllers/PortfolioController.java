package com.tbell.portfolio.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PortfolioController {

    @RequestMapping("/")
    public String index(){
        return "index";
    }
}
