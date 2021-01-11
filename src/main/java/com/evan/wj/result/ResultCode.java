package com.evan.wj.result;

/***
 * @description
 * @author diaoxiuze
 * @date 2021/1/7 13:56
 * @param
 * @return
 */
public class ResultCode {

    public static final int FAIL = 400;

    public static final int SUCCESS = 200;

    public static final int UNAUTHORIZED = 401;

    public static final int NOT_FOUND = 404;

    public static final int INTERNAL_SERVER_ERROR = 500;

    public int code;

    public ResultCode(int code) {
        this.code = code;
    }
}
