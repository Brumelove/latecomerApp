package com.exquis.latecomerapp.usecase.service;

import com.exquis.latecomerapp.domain.EmployeeEntity;
import com.exquis.latecomerapp.usecase.repository.EmployeeRepo;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
@Slf4j
public class EmployeeService {
    private final EmployeeRepo employeeRepo;

    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    public EmployeeEntity createOrUpdateEmployee(EmployeeEntity employeeEntity) {
        Optional<EmployeeEntity> optionalEmployeeEntity = employeeRepo.findById(employeeEntity.getId());
        EmployeeEntity employee = new EmployeeEntity();

        if (optionalEmployeeEntity.isPresent()) {
            employee = optionalEmployeeEntity.get();
        }

        employee.setAddress(employeeEntity.getAddress());
        employee.setEmail(employeeEntity.getEmail());
        employee.setEmployeeTimeOfArrival(employeeEntity.getEmployeeTimeOfArrival());
        employee.setName(employeeEntity.getName());
        employee.setScheduledTimeOfArrival(employeeEntity.getScheduledTimeOfArrival());


        return employeeRepo.save(employee);
    }



    public Map<String, Boolean> deleteEmployee(Long employeeId) {
        Optional<EmployeeEntity> optionalEmployeeEntity = employeeRepo.findById(employeeId);
        EmployeeEntity employee;

        if (optionalEmployeeEntity.isPresent()) {
            employee = optionalEmployeeEntity.get();
            employeeRepo.delete(employee);
        }
        else throw new ResourceNotFoundException("Employee not found for this id");

        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);

        return response;
    }
}
