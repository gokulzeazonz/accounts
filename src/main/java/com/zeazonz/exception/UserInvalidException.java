package com.zeazonz.exception;

public class UserInvalidException extends  RuntimeException {

    public  UserInvalidException(){
        super();
    }

    public  UserInvalidException(Throwable e){
        super(e);
    }

    public  UserInvalidException(String cause){
        super(cause);
    }

    public  UserInvalidException(String cause,Throwable e){
        super(cause,e);
    }

}
