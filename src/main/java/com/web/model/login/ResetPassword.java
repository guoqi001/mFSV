package com.web.model.login;

import com.alibaba.fastjson.annotation.JSONType;

/**
 * Created by jiangmq1 on 2017/5/16.
 */
@JSONType(orders = {"mobileNo","validateCode","newPassword","confrimNewPassword"})
public class ResetPassword {
    private String mobileNo;
    private String validateCode ;
    private String newPassword;
    private String confrimNewPassword;

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getValidateCode() {
        return validateCode;
    }

    public void setValidateCode(String validateCode) {
        this.validateCode = validateCode;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getConfrimNewPassword() {
        return confrimNewPassword;
    }

    public void setConfrimNewPassword(String confrimNewPassword) {
        this.confrimNewPassword = confrimNewPassword;
    }
}
