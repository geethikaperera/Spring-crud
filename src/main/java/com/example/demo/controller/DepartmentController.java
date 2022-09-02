package com.example.demo.controller;

import com.example.demo.entity.Department;
import com.example.demo.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/department")
    public Department saveDepartment(@Validated @RequestBody Department department){
        return departmentService.saveDepartment(department);
    }

    @GetMapping("departments")
    public List<Department> fetchDepatmentList(){
        return departmentService.fetchDepartmentList();
    }

    @PutMapping("/departments/{id}")
    public Department updateDepartment (@RequestBody Department department,
                                        @PathVariable ("id") Long departmentId){
        return departmentService.updateDepartment(department, departmentId);
    }

    @DeleteMapping("depatment/{id}")
    public String deleteDepartmentById(@PathVariable ("id") Long departmentId){
        departmentService.deleteDepartmentById(departmentId);
        return "Department" + departmentId + "deleted Successfully";
    }

}
