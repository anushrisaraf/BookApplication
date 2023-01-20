package com.curdexample.BookApplication.BookException;

public class InvalidEntryException extends RuntimeException{

    public InvalidEntryException(String msg)
    {
        super(msg);
    }
}
