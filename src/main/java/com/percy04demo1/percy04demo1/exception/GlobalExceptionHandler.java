package com.percy04demo1.percy04demo1.exception;

import com.percy04demo1.percy04demo1.dto.response.APIResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
//    ResponseEntity<String> handlingRuntimeException(RuntimeException exception){
//        return ResponseEntity.badRequest().body(exception.getMessage());
//    }
    ResponseEntity<APIResponse> handlingRuntimeException (RuntimeException exception){
        APIResponse apiResponse = new APIResponse();
        apiResponse.setCode(ErrorCode.UNCATEGORIZED_EXCEPTION.getCode());
        apiResponse.setMessage(ErrorCode.UNCATEGORIZED_EXCEPTION.getMessage());

        return  ResponseEntity.badRequest().body(apiResponse);
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    ResponseEntity<APIResponse> handlingValidation(MethodArgumentNotValidException exception){
        String enumkey = exception.getFieldError().getDefaultMessage() ;
        ErrorCode errorCode = ErrorCode.INVALID_KEY;

        try{
            errorCode = ErrorCode.valueOf(enumkey);
        } catch (IllegalArgumentException e){

        }


        APIResponse apiResponse = new APIResponse();
        apiResponse.setCode(errorCode.getCode());
        apiResponse.setMessage(errorCode.getMessage());

        return ResponseEntity.badRequest().body(apiResponse);
    }

    @ExceptionHandler(value = AppException.class)
//    ResponseEntity<String> handlingRuntimeException(RuntimeException exception){
//        return ResponseEntity.badRequest().body(exception.getMessage());
//    }
    ResponseEntity<APIResponse> handlingAppException (AppException exception){
        ErrorCode errorCode = exception.getErrorCode();
        APIResponse apiResponse = new APIResponse();

        apiResponse.setCode(errorCode.getCode());
        apiResponse.setMessage(errorCode.getMessage());

        return  ResponseEntity.badRequest().body(apiResponse);
    }
}
