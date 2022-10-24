package com.jpatest.controller;

import com.jpatest.model.Employees;
import com.jpatest.repository.EmployeesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;

@RestController
@RequestMapping(value = "/jpaTest/*")
public class JPATestController {

    @Autowired
    EmployeesRepository employeesRepository;

    @GetMapping(name = "조회용", value = "/select")
    public Object getEmployeeController(HttpServletRequest request, HttpServletResponse response){
        return employeesRepository.findById(10001);
    }

    @GetMapping(name = "insert용", value = "/insert")
    public Object insertEmployeeController(HttpServletRequest request, HttpServletResponse response){
        return employeesRepository.save(new Employees(500000, new java.util.Date(), "Hojun", "Choi", "M", new java.util.Date()));
    }

}
