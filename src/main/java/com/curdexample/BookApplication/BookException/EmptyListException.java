package com.curdexample.BookApplication.BookException;

public class EmptyListException extends RuntimeException{

    public EmptyListException(String msg)
    {
        super(msg);
    }
}
