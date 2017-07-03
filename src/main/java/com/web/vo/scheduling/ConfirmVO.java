package com.web.vo.scheduling;

/**
 * Created by jiangmq1 on 2017/5/22.
 */
public class ConfirmVO {
    private int status;
    private int messageId=1;
    private String messageText="";

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }
}
