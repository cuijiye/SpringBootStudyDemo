package com.example.demo.config;

import com.example.demo.controller.LoginHandlerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Package: com.example.demo.config
 * @ClassName: MyMvcConfig
 * @Author: cuiji
 * @CreateTime: 2021/4/1 14:12
 * @Description:
 */
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/login.html").setViewName("login");
        registry.addViewController("/main.html").setViewName("index");
    }

    //自定义的国际化组件生效
    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }

    //自定义拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHandlerInterceptor())
                .addPathPatterns("/**") //拦截的请求路径，全部拦截
                .excludePathPatterns("/","/login.html","/user/login","/css/**","/js/**","/img/**","/data/**","/fonts/**","/icons-reference/**","/vendor/**"); //不需要拦截的路径（静态资源+登录页）
    }
}
