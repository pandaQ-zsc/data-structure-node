package com.example.demo.exception;

/**
 * @author: xiong.qiang
 * @date: 2023/2/21 20:49
 */
public class ServiceException extends  Exception {
    private Integer exceptionCode;

    private String message;

    public ServiceException() {
        super();
    }

    public Integer getExceptionCode() {
        return exceptionCode;
    }

    public void setExceptionCode(Integer exceptionCode) {
        this.exceptionCode = exceptionCode;
    }

    public ServiceException(Integer exceptionCode, String message) {
        super(message);
        this.setExceptionCode(exceptionCode);
    }

    public ServiceException(String message) {
        super(message);
    }


}
