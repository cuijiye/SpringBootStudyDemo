package com.example.demo;

import com.example.demo.pojo.Dog;
import com.example.demo.pojo.Person;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class DemoApplicationTests {

    @Resource
    private Person person;

    @Test
    void contextLoads() {
        System.out.println(person);
    }

}
