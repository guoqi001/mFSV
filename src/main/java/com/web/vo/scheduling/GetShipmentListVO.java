package com.web.vo.scheduling;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jiangmq1 on 2017/5/22.
 */
public class GetShipmentListVO {
    private List<ShipmentListVO> shipmentList=new ArrayList<ShipmentListVO>();
    private int status;
    private String messageText="";

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public List<ShipmentListVO> getShipmentList() {
        return shipmentList;
    }

    public void setShipmentList(List<ShipmentListVO> shipmentList) {
        this.shipmentList = shipmentList;
    }
}
