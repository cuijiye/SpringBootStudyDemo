package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@Controller
public class LoginController {

    @RequestMapping("/user/login")
    public String login(@RequestParam("loginUsername") String loginUsername, @RequestParam("loginPassword") String loginPassword, Model model, HttpSession session){

        if ("admin".equals(loginUsername) && "111111".equals(loginPassword)){
            session.setAttribute("loginUser", loginUsername);
            return "redirect:/main.html";
        }else {
            model.addAttribute("msg", "用户名或密码错误！");
            return "login";
        }
    }

    @RequestMapping("/user/logout")
    public String logout(Model model, HttpSession session){
        session.removeAttribute("loginUser");
        return "redirect:/login.html";
    }
}
