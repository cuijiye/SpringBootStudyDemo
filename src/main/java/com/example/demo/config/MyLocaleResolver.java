package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

//自定义国际化组件
@Configuration
public class MyLocaleResolver implements LocaleResolver {
    @Override
    public Locale resolveLocale(HttpServletRequest httpServletRequest) {
        //获取请求中的语音参数
        String language = httpServletRequest.getParameter("language");

        Locale locale = Locale.getDefault();//如果没有使用默认值

        //如果请求的链接携带了国际化的参数
        if (!StringUtils.isEmpty(language)){
            //zh_CN
            String[] str = language.split("_");
            //语言，国家
            locale = new Locale(str[0], str[1]);
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }
}
