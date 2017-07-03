package com.web.model.scheduling;

import com.alibaba.fastjson.annotation.JSONType;

/**
 * Created by jiangmq1 on 2017/5/23.
 */
@JSONType(orders = {"driverNo","shipmentCode"})
public class GetDriverOutlet {

    private String driverNo;
    private String shipmentCode;

    public String getDriverNo() {
        return driverNo;
    }

    public void setDriverNo(String driverNo) {
        this.driverNo = driverNo;
    }

    public String getShipmentCode() {
        return shipmentCode;
    }

    public void setShipmentCode(String shipmentCode) {
        this.shipmentCode = shipmentCode;
    }
}
