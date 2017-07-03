package com.web.vo.login;

/**
 * Created by jiangmq1 on 2017/5/16.
 */
public class ValidateMobileNoVO {
    private int status;
    private String messageText="";

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }
}
