package com.example.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Package: com.example.demo.pojo
 * @ClassName: Employee
 * @Author: cuiji
 * @CreateTime: 2021/5/6 23:24
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    private Integer id;
    private String name;
    private String email;
    private Integer gender;
    private Department department;
    private Date birth;
}
