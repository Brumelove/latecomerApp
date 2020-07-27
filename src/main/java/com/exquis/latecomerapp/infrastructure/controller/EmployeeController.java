package com.exquis.latecomerapp.infrastructure.controller;

import com.exquis.latecomerapp.domain.EmployeeEntity;
import com.exquis.latecomerapp.usecase.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class EmployeeController {
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/create/employee")
    public ResponseEntity<?> createPost(@Valid @RequestBody EmployeeEntity employeeEntity) {
        return ResponseEntity.
                accepted().
                body(employeeService.
                        createOrUpdateEmployee(employeeEntity));
    }
    @PutMapping("/update/employee")
    public ResponseEntity<?>updatePost(@Valid @RequestBody EmployeeEntity employeeEntity) {
        return ResponseEntity.
                accepted().
                body(employeeService.
                        createOrUpdateEmployee(employeeEntity));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletePost(@PathVariable(value = "id") Long employeeId) {
        return ResponseEntity.
                accepted().
                body(employeeService.
                        deleteEmployee(employeeId));
    }
}