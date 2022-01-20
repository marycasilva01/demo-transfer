package com.br.demo.transfer.entrypoint.exception;

import com.br.demo.transfer.common.exceptions.BusinessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ResponseBody
    @ExceptionHandler(BusinessException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    ExceptionDTO businessExceptionHandler(BusinessException ex) {
        return new ExceptionDTO(HttpStatus.UNPROCESSABLE_ENTITY.value(), ex.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    ExceptionDTO businessExceptionHandler(Exception ex) {
        ExceptionDTO exceptionDTO = new ExceptionDTO(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage());
        exceptionDTO.setDetail(ex.getLocalizedMessage());
        return exceptionDTO;
    }
}
