package com.example.demo.dao;

import com.example.demo.pojo.Department;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @Package: com.example.demo.dao
 * @ClassName: DepartmentDao
 * @Author: cuiji
 * @CreateTime: 2021/5/6 23:27
 * @Description:
 */
//部门dao
@Repository
public class DepartmentDao {

    //模拟数据库中的数据
    private static Map<Integer, Department> departments = null;

    static {
        departments = new HashMap<Integer, Department>();

        departments.put(101, new Department(101,"教学部"));
        departments.put(102, new Department(102,"体育部"));
        departments.put(103, new Department(103,"图书部"));
        departments.put(104, new Department(104,"绘画部"));
        departments.put(105, new Department(105,"团支部"));
    }

    //获得所有的部门信息
    public Collection<Department> getDepartments(){
        return departments.values();
    }

    //通过id获取部门信息
    public Department getDepartmentByid(Integer id){
        return departments.get(id);
    }
}
