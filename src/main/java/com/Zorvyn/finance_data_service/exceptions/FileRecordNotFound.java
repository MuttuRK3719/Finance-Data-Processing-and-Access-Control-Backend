package com.Zorvyn.finance_data_service.exceptions;


public class FileRecordNotFound extends RuntimeException{
    public FileRecordNotFound(String message){
        super(message);
    }
}
