package com.web.model.scheduling;

import com.alibaba.fastjson.annotation.JSONType;

/**
 * Created by jiangmq1 on 2017/5/22.
 */
@JSONType(orders = {"token","driverNo","shipmentType"})
public class GetShipmentList {
    private String token;
    private String driverNo;
    private String shipmentType="Z002";

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getDriverNo() {
        return driverNo;
    }

    public void setDriverNo(String driverNo) {
        this.driverNo = driverNo;
    }

    public String getShipmentType() {
        return shipmentType;
    }

    public void setShipmentType(String shipmentType) {
        this.shipmentType = shipmentType;
    }
}
