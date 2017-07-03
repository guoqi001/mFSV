package com.web.vo.scheduling;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jiangmq1 on 2017/5/23.
 */
public class GetCustomerDeviceListVO {
    private int status;
    private List<DeviceListVO> deviceList=new ArrayList<DeviceListVO>();
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

    public List<DeviceListVO> getDeviceList() {
        return deviceList;
    }

    public void setDeviceList(List<DeviceListVO> deviceList) {
        this.deviceList = deviceList;
    }
}
