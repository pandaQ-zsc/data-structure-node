package com.example.demo.exception;

import com.example.demo.entity.ResponseData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author: xiong.qiang
 * @date: 2023/3/15 10:07
 */

@Slf4j
@RestControllerAdvice(basePackages = "com.example.demo.controller")
public class ExceptionControllerAdvice {
    //    @ExceptionHandler(value = {IllegalArgumentException.class})
//    public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException e) {
//        e.printStackTrace();
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid request: " + e.getMessage());
//    }
    @ExceptionHandler(value = {IllegalArgumentException.class})
    public ResponseData<Object> handleIllegalArgumentException(IllegalArgumentException e) {
        e.printStackTrace();
        return ResponseData.error().setData("---Invalid request: " + e.getMessage());
    }

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<String> handleException(Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal server error: " + e.getMessage());
    }

}
