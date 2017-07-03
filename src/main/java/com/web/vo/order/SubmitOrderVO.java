package com.web.vo.order;

/**
 * Created by jiangmq1 on 2017/5/18.
 */
public class SubmitOrderVO {
    private int status;
    private int result;
    private String  message="";

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
