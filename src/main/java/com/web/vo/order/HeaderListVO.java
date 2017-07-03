package com.web.vo.order;

/**
 * Created by jiangmq1 on 2017/5/17.
 */
public class HeaderListVO {
    private String foTranCode;
    private String mysccTranCode;
    private String sapTranCode;
    private String orderDate;
    private double priceTotal;
    private double oninvoiceDiscountTotal;
    private double offinvoiceDiscountTotal;
    private double depositTotal;
    private String docCode;
    private String receiveDate;
    private String tranOriginCode;
    private String deliveryFlg;
    private String usageCode;
    private String mainStatus;
    private String directshipStatus;

    public String getFoTranCode() {
        return foTranCode;
    }

    public void setFoTranCode(String foTranCode) {
        this.foTranCode = foTranCode;
    }

    public String getMysccTranCode() {
        return mysccTranCode;
    }

    public void setMysccTranCode(String mysccTranCode) {
        this.mysccTranCode = mysccTranCode;
    }

    public String getSapTranCode() {
        return sapTranCode;
    }

    public void setSapTranCode(String sapTranCode) {
        this.sapTranCode = sapTranCode;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public double getPriceTotal() {
        return priceTotal;
    }

    public void setPriceTotal(double priceTotal) {
        this.priceTotal = priceTotal;
    }

    public double getOninvoiceDiscountTotal() {
        return oninvoiceDiscountTotal;
    }

    public void setOninvoiceDiscountTotal(double oninvoiceDiscountTotal) {
        this.oninvoiceDiscountTotal = oninvoiceDiscountTotal;
    }

    public double getOffinvoiceDiscountTotal() {
        return offinvoiceDiscountTotal;
    }

    public void setOffinvoiceDiscountTotal(double offinvoiceDiscountTotal) {
        this.offinvoiceDiscountTotal = offinvoiceDiscountTotal;
    }

    public double getDepositTotal() {
        return depositTotal;
    }

    public void setDepositTotal(double depositTotal) {
        this.depositTotal = depositTotal;
    }

    public String getDocCode() {
        return docCode;
    }

    public void setDocCode(String docCode) {
        this.docCode = docCode;
    }

    public String getReceiveDate() {
        return receiveDate;
    }

    public void setReceiveDate(String receiveDate) {
        this.receiveDate = receiveDate;
    }

    public String getTranOriginCode() {
        return tranOriginCode;
    }

    public void setTranOriginCode(String tranOriginCode) {
        this.tranOriginCode = tranOriginCode;
    }

    public String getDeliveryFlg() {
        return deliveryFlg;
    }

    public void setDeliveryFlg(String deliveryFlg) {
        this.deliveryFlg = deliveryFlg;
    }

    public String getUsageCode() {
        return usageCode;
    }

    public void setUsageCode(String usageCode) {
        this.usageCode = usageCode;
    }

    public String getMainStatus() {
        return mainStatus;
    }

    public void setMainStatus(String mainStatus) {
        this.mainStatus = mainStatus;
    }

    public String getDirectshipStatus() {
        return directshipStatus;
    }

    public void setDirectshipStatus(String directshipStatus) {
        this.directshipStatus = directshipStatus;
    }
}
