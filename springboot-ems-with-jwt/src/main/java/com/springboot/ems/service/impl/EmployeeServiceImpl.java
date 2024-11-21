package com.springboot.ems.service.impl;

import com.springboot.ems.entiry.EmployeeEntity;
import com.springboot.ems.exception.ResourceNotFoundException;
import com.springboot.ems.model.EmployeeRequest;
import com.springboot.ems.model.EmployeeResponse;
import com.springboot.ems.repository.EmployeeRepository;
import com.springboot.ems.service.EmployeeService;
import com.springboot.ems.utils.EmployeeMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;

    @Override
    public String addOrUpdateEmployee(EmployeeRequest employeeRequest, Long employeeId) {
        String response = null;
        if(employeeId!= null){
            employeeRepository.saveAndFlush(EmployeeMapper.mapEmployeeRequestToEmployeeEntity(employeeRequest));
            response = "Employee updated successfully.";
        }else {
            employeeRepository.save(EmployeeMapper.mapEmployeeRequestToEmployeeEntity(employeeRequest));
            response = "Employee added successfully.";
        }
        return response;
    }

    @Override
    public EmployeeResponse getEmployee(Long id) {
        EmployeeEntity employeeEntity = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Todo not found with id:" + id));;
        return EmployeeMapper.mapEmployeeEntityToEmployeeResponse(employeeEntity);
    }

    @Override
    public List<EmployeeResponse> getAllEmployee() {
        List<EmployeeEntity> listOfEmployeeEntity = employeeRepository.findAll();
        return listOfEmployeeEntity.stream().map(employeeEntity->EmployeeMapper.mapEmployeeEntityToEmployeeResponse(employeeEntity)).collect(Collectors.toList());
    }

    @Override
    public String deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
        return "deleted successfully";
    }
}
