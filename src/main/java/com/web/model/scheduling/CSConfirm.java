package com.web.model.scheduling;

import com.alibaba.fastjson.annotation.JSONType;

/**
 * Created by jiangmq1 on 2017/5/22.
 */
@JSONType(orders = {"token","shipmentCode","csConfirm"})
public class CSConfirm {
    private  String token;
    private String shipmentCode;
    private Integer csConfirm;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getShipmentCode() {
        return shipmentCode;
    }

    public void setShipmentCode(String shipmentCode) {
        this.shipmentCode = shipmentCode;
    }

    public Integer getCsConfirm() {
        return csConfirm;
    }

    public void setCsConfirm(Integer csConfirm) {
        this.csConfirm = csConfirm;
    }
}
