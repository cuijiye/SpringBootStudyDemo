package com.example.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Package: com.example.demo.pojo
 * @ClassName: Department
 * @Author: cuiji
 * @CreateTime: 2021/5/6 23:07
 * @Description:
 */
//部门表
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department {
    private Integer id;
    private String departmentName;
}
