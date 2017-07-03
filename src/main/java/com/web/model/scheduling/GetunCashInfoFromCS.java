package com.web.model.scheduling;

import com.alibaba.fastjson.annotation.JSONType;

/**
 * Created by jiangmq1 on 2017/5/25.
 */
@JSONType(orders = {"token","shipmentcode","outletNo"})
public class GetunCashInfoFromCS {
    private String token;
    private String shipmentcode;
    private String outletNo;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getShipmentcode() {
        return shipmentcode;
    }

    public void setShipmentcode(String shipmentcode) {
        this.shipmentcode = shipmentcode;
    }

    public String getOutletNo() {
        return outletNo;
    }

    public void setOutletNo(String outletNo) {
        this.outletNo = outletNo;
    }
}
