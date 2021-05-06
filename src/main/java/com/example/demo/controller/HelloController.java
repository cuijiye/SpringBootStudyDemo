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
        model.addAttribute("msg2", "<h2>hello,SpringBoot</h2>");
        model.addAttribute("msg3", "<h3>hello,SpringBoot</h3>");
        model.addAttribute("msg4", "<h4>hello,SpringBoot</h4>");
        model.addAttribute("msg6", "<h6>hello,SpringBoot</h6>");
        model.addAttribute("msg5", "<h5>hello,SpringBoot</h5>");
        model.addAttribute("GitHub push", "<h5>hello,SpringBoot</h5>");
        model.addAttribute("users", Arrays.asList("zhangsan", "lisi", "wangwu"));
        return "hello";
    }

}
