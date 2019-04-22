package com.zeazonz.exception;

public class DatabaseException extends  RuntimeException {

    public  DatabaseException(){
        super();
    }

    public  DatabaseException(Throwable e){
        super(e);
    }

    public  DatabaseException(String cause){
        super(cause);
    }

    public  DatabaseException(String cause,Throwable e){
        super(cause,e);
    }

}
