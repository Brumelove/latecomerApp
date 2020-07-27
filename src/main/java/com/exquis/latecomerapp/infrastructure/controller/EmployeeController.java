package com.exquis.latecomerapp.infrastructure.controller;

import com.exquis.latecomerapp.domain.entity.Employee;
import com.exquis.latecomerapp.usecase.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@AllArgsConstructor
public class EmployeeController {

    private EmployeeService employeeService;


    @PostMapping("/create/employee")
    public ResponseEntity<?> createPost(@Valid @RequestBody Employee employee) {
        return ResponseEntity.
                accepted().
                body(employeeService.
                        createOrUpdateEmployee(employee));
    }
    @PutMapping("/update/employee")
    public ResponseEntity<?>updatePost(@Valid @RequestBody Employee employee) {
        return ResponseEntity.
                accepted().
                body(employeeService.
                        createOrUpdateEmployee(employee));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletePost(@PathVariable(value = "id") Long employeeId) {
        return ResponseEntity.
                accepted().
                body(employeeService.
                        deleteEmployee(employeeId));
    }
}