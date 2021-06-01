package com.example.demo.dao;

import com.example.demo.pojo.Department;
import com.example.demo.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Package: com.example.demo.dao
 * @ClassName: EmployeeDao
 * @Author: cuiji
 * @CreateTime: 2021/5/6 23:35
 * @Description:
 */
//员工dao
@Repository
public class EmployeeDao {

    //模拟数据库中的数据
    private static Map<Integer, Employee> employees = null;
    @Autowired
    private DepartmentDao departmentDao;

    static {
        employees = new HashMap<Integer, Employee>();

        employees.put(101, new Employee(1001,"张三","1234567891@qq.com",0,new Department(101, "教学部"),new Date()));
        employees.put(102, new Employee(1002,"李四","1234567892@qq.com",1,new Department(102, "体育部"),new Date()));
        employees.put(103, new Employee(1003,"王五","1234567893@qq.com",0,new Department(103, "图书部"),new Date()));
        employees.put(104, new Employee(1004,"马六","1234567894@qq.com",1,new Department(104, "绘画部"),new Date()));
        employees.put(105, new Employee(1005,"赵七","1234567895@qq.com",1,new Department(105, "团支部"),new Date()));
    }

    //主键自增
    private static Integer initId = 1006;

    //新增员工
    public void save(Employee employee){
        if (employee.getId() == null){
            employee.setId(initId++);
        }

        employee.setDepartment(departmentDao.getDepartmentByid(employee.getDepartment().getId()));

        employees.put(employee.getId(),employee);
    }

    //获取所有的员工信息
    public Collection<Employee> getEmployees(){
        return employees.values();
    }

    //通过id获取用户信息
    public Employee getEmployeeById(Integer id){
        return employees.get(id);
    }

    //删除员工
    public void deleteById(Integer id){
        employees.remove(id);
    }
}
