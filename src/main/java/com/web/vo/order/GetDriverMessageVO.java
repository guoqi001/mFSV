package com.web.vo.order;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jiangmq1 on 2017/5/18.
 */
public class GetDriverMessageVO {
    private int status;
    private List<MessageListVO> messageList=new ArrayList<MessageListVO>();
    private String message="";

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<MessageListVO> getMessageList() {
        return messageList;
    }

    public void setMessageList(List<MessageListVO> messageList) {
        this.messageList = messageList;
    }
}
