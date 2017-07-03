package com.web.model.login;

import com.alibaba.fastjson.annotation.JSONType;

/**
 * Created by jiangmq1 on 2017/5/16.
 */
@JSONType(orders = {"mobileNo","sendTag"})
public class GetValidateCode {
    private String mobileNo;
    private int sendTag;

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public int getSendTag() {
        return sendTag;
    }

    public void setSendTag(int sendTag) {
        this.sendTag = sendTag;
    }
}
