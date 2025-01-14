package com.percy04demo1.percy04demo1.exception;

import org.aspectj.apache.bcel.classfile.Code;

public enum ErrorCode {
    INVALID_KEY(1001,"Invalid message key") ,
    UNCATEGORIZED_EXCEPTION( 9999 , "Uncategorzied error") ,
    USER_EXISTED( 1002 , "User existed"),
    USERNAME_INVALID(1003,"Username must be at least 3 characters"),
    PASSWORD_INVALID(1004,"Password must be at least 8 characters"),
    USER_NOT_EXISTED( 1005 , "User existed"),
    UNAUTHENTICATED(1006,"Unauthenticated")

    ;
    private int code ;
    private String message ;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
