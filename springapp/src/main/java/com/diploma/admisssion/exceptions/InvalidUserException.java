package com.diploma.admisssion.exceptions;

public class InvalidUserException extends Exception{

    public InvalidUserException(){
        super("Inavlid Login Credentials");
    }
    
}
