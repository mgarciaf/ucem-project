/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ni.edu.ucem.webapi.web.error;

import ni.edu.ucem.webapi.core.ApiResponse;
import ni.edu.ucem.webapi.core.ApiResponse.ApiError;
import ni.edu.ucem.webapi.core.ApiResponse.Status;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Arlette Roger
 */

@RestController
@ControllerAdvice
public class GlobalExceptionHandler {
    
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({EmptyResultDataAccessException.class})
    public ApiResponse manejarRecursoNoEncontrado(Exception e){
        
        return new ApiResponse(Status.BAD_REQUEST, null, 
               new ApiError(Status.BAD_REQUEST.getValue(), e.getMessage().toString()));
    }
    
    
}
