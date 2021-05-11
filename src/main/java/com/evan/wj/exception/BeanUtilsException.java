package com.evan.wj.exception;

/**
 * @description:
 * @author: dxz
 * @date: 2021/5/11 10:29
 */
public class BeanUtilsException extends RuntimeException {

    public BeanUtilsException(String message, Throwable cause) {
        super(message, cause);
    }

    public BeanUtilsException(String message) {
        super(message);
    }
}
