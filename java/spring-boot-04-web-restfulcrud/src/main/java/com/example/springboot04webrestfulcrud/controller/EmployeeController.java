package com.example.springboot04webrestfulcrud.controller;

import com.example.springboot04webrestfulcrud.dao.DepartmentDao;
import com.example.springboot04webrestfulcrud.dao.EmployeeDao;
import com.example.springboot04webrestfulcrud.entities.Department;
import com.example.springboot04webrestfulcrud.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
public class EmployeeController {
    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    DepartmentDao departmentDao;

    //查询员工列表
    @GetMapping("/emps")
    public String list(Model model){
        Collection<Employee> employees = employeeDao.getAll();
        //放在请求域中
        model.addAttribute("emps",employees);
        //thymeleaf 默认拼串
        //classpath:/templates/xxx.html
        return "emp/list";
    }
    //添加部门
    @GetMapping("/emp")
    public String toAddPage(Model model){
        //添加页面，查出所有部门
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        return "emp/add";
    }
    //添加员工
    @PostMapping("/emp")
    public String addEmp(Employee employee){

        System.out.println("员工信息"+employee);
        employeeDao.save(employee);
        /*forword 表示转发
        redirect 表示重定向。。当前路径*/
        return "redirect:/emps";
    }

    //修改页面查询员工
    @GetMapping("/emp/{id}")
    public String toEditPage(@PathVariable("id") Integer id,Model model){
        Employee employee = employeeDao.get(id);
        model.addAttribute("emp",employee);

        //查出所有部门页面
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        //回到添加页面
        return "emp/add";
    }

    //员工修改
    @PutMapping("/emp")
    public String updateEmployee(Employee employee){
        System.out.println("返回员工数据："+employee);
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    //删除员工数据
    @DeleteMapping("/emp/{id}")
    public String deleteEmployee(@PathVariable("id") Integer id){

        employeeDao.delete(id);
        return "redirect:/emps";
    }
}
