package com.Zorvyn.finance_data_service.exceptions;

public class NoRecordExists extends RuntimeException{
    public NoRecordExists(String message){
        super(message);
    }
}
