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

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Result(int code) {
        this.code = code;
    }
}
