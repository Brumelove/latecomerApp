package com.exquis.latecomerapp.domain.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeApiException extends RuntimeException {

    private ErrorResponse errorResponse;
}
