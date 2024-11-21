package com.springboot.ems.controller;

import com.springboot.ems.model.EmployeeRequest;
import com.springboot.ems.model.EmployeeResponse;
import com.springboot.ems.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<String> addEmployee(@RequestBody EmployeeRequest employeeRequest){
       return new ResponseEntity<String>(employeeService.addOrUpdateEmployee(employeeRequest, null), HttpStatus.CREATED);
    }

    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @GetMapping("{id}")
    public ResponseEntity<EmployeeResponse> getEmployee(@PathVariable("id") Long employeeId){
        return new ResponseEntity<EmployeeResponse>(employeeService.getEmployee(employeeId), HttpStatus.OK);
    }
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @GetMapping
    public ResponseEntity<List<EmployeeResponse>> getAllEmployee(){
        return new ResponseEntity<List<EmployeeResponse>>(employeeService.getAllEmployee(), HttpStatus.OK);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("{id}")
    public ResponseEntity<String> updateEmployee(@RequestBody EmployeeRequest employeeRequest, @PathVariable("id") Long employeeId){
        return new ResponseEntity<String>(employeeService.addOrUpdateEmployee(employeeRequest, employeeId), HttpStatus.OK);
    }
}
