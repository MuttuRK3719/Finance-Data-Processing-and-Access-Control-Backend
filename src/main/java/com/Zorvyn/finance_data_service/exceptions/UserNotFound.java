package com.Zorvyn.finance_data_service.exceptions;

public class UserNotFound extends RuntimeException{
    public UserNotFound(String message){
        super(message);
    }
}
