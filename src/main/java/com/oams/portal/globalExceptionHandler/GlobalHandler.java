package com.oams.portal.globalExceptionHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.oams.portal.exceptions.BasicExceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class GlobalHandler extends ResponseEntityExceptionHandler{

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
            HttpHeaders headers, HttpStatus status, WebRequest request) {
                Map<String, Object> body = new HashMap<>();

                List<String> error = ex.getBindingResult()
                        .getFieldErrors()
                        .stream()
                        .map(x -> x.getDefaultMessage())
                        .collect(Collectors.toList());
        
                body.put("errors", error);
        
            return new ResponseEntity<>(body, headers, status);
    }

    @ExceptionHandler(BasicExceptions.class)
    public void handleBasicsException(BasicExceptions ex){
        log.info(ex.getMessage());
    }

    @ExceptionHandler(javax.validation.ConstraintViolationException.class)
    public void handleConstraintViolationException(javax.validation.ConstraintViolationException ex) {
        log.info(ex.getMessage());
    }


    

    
    
}
