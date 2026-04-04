package com.Zorvyn.finance_data_service.exceptions;

public class DuplicateUser extends RuntimeException{
    public DuplicateUser(String message){
        super(message);
    }
}
