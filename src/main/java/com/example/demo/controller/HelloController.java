package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;

/**
 * @Package: com.example.demo.controller
 * @ClassName: HelloController
 * @Author: cuiji
 * @CreateTime: 2021/3/31 11:14
 * @Description:
 */
@Controller
public class HelloController {

    @RequestMapping("/test")
    public String hello(Model model){
        model.addAttribute("msg", "<h1>hello,SpringBoot</h1>");
        model.addAttribute("users", Arrays.asList("zhangsan", "lisi", "wangwu"));
        return "hello";
    }

}
