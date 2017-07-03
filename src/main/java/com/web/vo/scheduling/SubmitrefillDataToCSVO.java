package com.web.vo.scheduling;

/**
 * Created by jiangmq1 on 2017/5/25.
 */
public class SubmitrefillDataToCSVO {
    private int status;
    private int result=1;
    private String message="";

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
