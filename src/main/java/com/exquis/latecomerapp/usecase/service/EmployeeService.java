package com.exquis.latecomerapp.usecase.service;

import com.exquis.latecomerapp.domain.entity.Employee;
import com.exquis.latecomerapp.usecase.repository.EmployeeRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
@Slf4j

public class EmployeeService {
    private  EmployeeRepo employeeRepo;
    @Value("${lateComerFine}")
    private Integer lateComerFine;

    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }


    public Employee createOrUpdateEmployee(Employee employeeEntity) {
        Optional<Employee> optionalEmployeeEntity = employeeRepo.findById(employeeEntity.getId());
        Employee employee  = new Employee();

        if (optionalEmployeeEntity.isPresent()) {
            employee = optionalEmployeeEntity.get();
        }


        employee.setAddress(employeeEntity.getAddress());
        employee.setEmail(employeeEntity.getEmail());
        employee.setEmployeeName(employeeEntity.getEmployeeName());
        employee.setScheduledTimeOfArrival(employeeEntity.getScheduledTimeOfArrival());        employee.setEmployeeTimeOfArrival(employeeEntity.getEmployeeTimeOfArrival());
        employee.setEmployeeTimeOfArrival(employeeEntity.getEmployeeTimeOfArrival());


        long diff = ChronoUnit.MINUTES.between( employeeEntity.getEmployeeTimeOfArrival(), employeeEntity.getScheduledTimeOfArrival());


        employee.setEmployeeGbese(diff * lateComerFine + "$");




        return employeeRepo.save(employee);
    }



    public Map<String, Boolean> deleteEmployee(Long employeeId) {
        Optional<Employee> optionalEmployeeEntity = employeeRepo.findById(employeeId);
        Employee employee;

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
