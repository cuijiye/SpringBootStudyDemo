package com.example.demo.controller;

import com.example.demo.dao.DepartmentDao;
import com.example.demo.dao.EmployeeDao;
import com.example.demo.pojo.Department;
import com.example.demo.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    private DepartmentDao departmentDao;

    /**
     * 跳转员工列表页
     * @param model
     * @return
     */
    @RequestMapping("/goList")
    public String goList(Model model){
        Collection<Employee> employees = employeeDao.getEmployees();
        model.addAttribute("employees",employees);
        return "employee/list";
    }

    /**
     * 跳转员工新增页面
     * @param model
     * @return
     */
    @RequestMapping("/goAddEmp")
    public String goAddEmp(Model model){
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("departments",departments);
        return "employee/add";
    }

    /**
     * 新增员工方法
     * @param employee
     * @return
     */
    @RequestMapping("/addEmp")
    public String addEmp(Employee employee){
        employeeDao.save(employee);
        return "redirect:/goList";
    }

    /**
     * 跳转员工修改页面
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/goUpdateEmp/{id}")
    public String goUpdateEmp(@PathVariable("id")Integer id, Model model){
        Employee employee = employeeDao.getEmployeeById(id);
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("departments",departments);
        model.addAttribute("employee",employee);
        return "employee/update";
    }

    /**
     * 修改员工信息方法
     * @param employee
     * @return
     */
    @RequestMapping("/updateEmp")
    public String updateEmp(Employee employee){
        employeeDao.save(employee);
        return "redirect:/goList";
    }

    /**
     * 删除员工信息
     * @param id
     * @return
     */
    @GetMapping("/deleteEmp/{id}")
    public String deleteEmp(@PathVariable("id")Integer id){
        employeeDao.deleteById(id);
        return "redirect:/goList";
    }
}
