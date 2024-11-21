package com.springboot.ems.utils;

import com.springboot.ems.entiry.EmployeeEntity;
import com.springboot.ems.model.EmployeeRequest;
import com.springboot.ems.model.EmployeeResponse;

public class EmployeeMapper {
    public static EmployeeEntity mapEmployeeRequestToEmployeeEntity(EmployeeRequest employeeRequest) {
        return EmployeeEntity.builder()
                .id(employeeRequest.getId())
                .name(employeeRequest.getName())
                .email(employeeRequest.getEmail())
                .gender(employeeRequest.getGender())
                .contact(employeeRequest.getContact()).build();
    }

    public static EmployeeResponse mapEmployeeEntityToEmployeeResponse(EmployeeEntity employeeEntity){
        return EmployeeResponse.builder()
                .id(employeeEntity.getId())
                .name(employeeEntity.getName())
                .gender(employeeEntity.getGender())
                .email(employeeEntity.getEmail())
                .contact(employeeEntity.getContact())
                .address(employeeEntity.getAddress()).build();
    }
}
