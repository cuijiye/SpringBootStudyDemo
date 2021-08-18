package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IndexController {

    @RequestMapping("/index")
    public String goIndex(){
        return "index";
    }

    @RequestMapping("/charts")
    public String goCharts(){
        return "charts";
    }

    @RequestMapping("/forms")
    public String goForms(){
        return "forms";
    }

    @RequestMapping("/tables")
    public String goTables(){
        return "tables";
    }
}
