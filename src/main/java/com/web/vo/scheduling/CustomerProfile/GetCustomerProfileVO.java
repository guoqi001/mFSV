package com.web.vo.scheduling.CustomerProfile;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jiangmq1 on 2017/5/24.
 */
public class GetCustomerProfileVO {
    private int status;
    private List<UserAttributeVO> user_attribute=new ArrayList<UserAttributeVO>();
    private String isAsset;
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

    public List<UserAttributeVO> getUser_attribute() {
        return user_attribute;
    }

    public void setUser_attribute(List<UserAttributeVO> user_attribute) {
        this.user_attribute = user_attribute;
    }

    public String getIsAsset() {
        return isAsset;
    }

    public void setIsAsset(String isAsset) {
        this.isAsset = isAsset;
    }
}
