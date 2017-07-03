package com.web.vo.scheduling;

/**
 * Created by jiangmq1 on 2017/5/22.
 */
public class ShipmentListVO {
    private String shipmentCode;
    private String deliveryDate;
    private int orderCount;
    private int deliveryStatus;
    private String deliveryStatusDesc;
    private int isTransShipment;

    public String getShipmentCode() {
        return shipmentCode;
    }

    public void setShipmentCode(String shipmentCode) {
        this.shipmentCode = shipmentCode;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public int getOrderCount() {
        return orderCount;
    }

    public void setOrderCount(int orderCount) {
        this.orderCount = orderCount;
    }

    public int getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(int deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }

    public String getDeliveryStatusDesc() {
        return deliveryStatusDesc;
    }

    public void setDeliveryStatusDesc(String deliveryStatusDesc) {
        this.deliveryStatusDesc = deliveryStatusDesc;
    }

    public int getIsTransShipment() {
        return isTransShipment;
    }

    public void setIsTransShipment(int isTransShipment) {
        this.isTransShipment = isTransShipment;
    }
}
