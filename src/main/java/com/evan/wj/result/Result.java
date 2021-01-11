package com.evan.wj.result;

/***
 * @description
 * @author diaoxiuze
 * @date 2020/12/5 6:01
 * @param
 * @return
 */
public class Result {
    /**
     * 响应码
      */
    private int code;

    private String message;

    private Object result;

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

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public Result(int code, String message, Object result) {
        this.code = code;
        this.message = message;
        this.result = result;
    }
}
