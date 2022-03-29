package com.diploma.admisssion.exceptions;


public class InstituteAlreadyExistException extends Exception {
    public InstituteAlreadyExistException (String institutename){
            super("Institute name already exist"+institutename);
    }
}
