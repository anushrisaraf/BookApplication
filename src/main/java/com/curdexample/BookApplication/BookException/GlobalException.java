package com.curdexample.BookApplication.BookException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalException {

    @ExceptionHandler(value=InvalidEntryException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public @ResponseBody ErrorResponse InvalidEntryException(InvalidEntryException e)
    {
        ErrorResponse errorResponse = new ErrorResponse((HttpStatus.CONFLICT.value()),e.getMessage());
        return errorResponse;
    }

    @ExceptionHandler(value=EmptyListException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody ErrorResponse EmptyListException(EmptyListException e)
    {
        ErrorResponse erroresponse=new ErrorResponse(HttpStatus.BAD_REQUEST.value(),e.getMessage());
        return erroresponse;
    }

}
