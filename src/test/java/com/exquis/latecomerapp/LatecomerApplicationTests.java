package com.exquis.latecomerapp;

import com.exquis.latecomerapp.domain.entity.Employee;
import com.exquis.latecomerapp.usecase.repository.EmployeeRepo;
import com.exquis.latecomerapp.usecase.service.EmployeeService;
import lombok.val;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.test.context.event.annotation.BeforeTestMethod;


import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
class LatecomerApplicationTests {
    @Autowired
    private EmployeeService employeeService;

    @MockBean
    private EmployeeRepo employeeRepo;
    private Employee employee;

//@BeforeEach
//public void setup() {
//        employee = new Employee();
//        employee.setAddress("flic en flac");
//        employee.setEmail("brumelovee@gmail.com");
//        employee.setEmployeeGbese("345$");
//        employee.setId(1l);
//
//    }


    @Test
    @DisplayName("Test Delete by Id")
    void testFDeleteById() {
        Employee employee2 = new Employee();

        // Setup our mock repository
        employee2.setEmployeeGbese("345$");
        employee2.setId(1l);
        doReturn(Optional.of(employee2)).when(employeeRepo).findById(1l);

        // Execute the service call
        Map<String, Boolean> optionalEmployee = employeeService.deleteEmployee(1l);

        // Assert the response
        Assertions.assertFalse(optionalEmployee.isEmpty(), "Employee Was not found");
        Assertions.assertSame(optionalEmployee.get(0), employee, "The Employee returned was not the same as the mock");

    }

    @Test
    @DisplayName("Gbese calculation")
    void employeeGbese() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime tenMinutesLater = now.plusMinutes(10);

        long diff = ChronoUnit.MINUTES.between(now, tenMinutesLater);
        long result = diff * 20;

        assertEquals(result, 200);

    }

}
