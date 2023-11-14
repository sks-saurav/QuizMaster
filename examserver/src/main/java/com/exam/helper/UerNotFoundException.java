package com.exam.helper;

public class UerNotFoundException extends Exception{
    public UerNotFoundException() {
        super("User with this username does not exists!!");
    }
    public UerNotFoundException(String msg) { super(msg);}
}
