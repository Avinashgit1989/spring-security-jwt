package com.springboot.ems.service;

import com.springboot.ems.model.EmployeeRequest;
import com.springboot.ems.model.EmployeeResponse;
import org.springframework.stereotype.Service;

import java.util.List;

public interface EmployeeService {
    String addOrUpdateEmployee(EmployeeRequest employeeRequest, Long employeeId);
    EmployeeResponse getEmployee(Long id);
    List<EmployeeResponse> getAllEmployee();
    String deleteEmployee(Long id);

}
