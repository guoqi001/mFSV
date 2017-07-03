package com.web.model.order;

import com.alibaba.fastjson.annotation.JSONType;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jiangmq1 on 2017/5/18.
 */
@JSONType(orders = {"tranCodeSRC","orderType","usageCode","staffCode","deliveryInstructions","dispatchInstructions",
        "soldToNo","shipToNo","activeFlg","callingDate","deliveryDate","useAdvancedpayment","tranCodeExternal","directshipCode",
        "autoreleaseLimitFlg","selfSalingFlg","tranOriginCode","clientCreateDate","clientCreateBy","clientUpdateDate","clientUpdateBy",
        "signatureData","modifyReasonCode","orderItemList"})
public class SubmitOrder {
    private String tranCodeSRC="";
    private String orderType="ZROD";
    private String usageCode="";
    private String staffCode="";
    private String deliveryInstructions="";
    private String dispatchInstructions="";
    private String soldToNo="";
    private String shipToNo="";
    private int activeFlg=1;
    private String callingDate="";
    private String deliveryDate="";
    private int useAdvancedpayment=0;
    private String tranCodeExternal="";
    private int directshipCode=0;
    private int autoreleaseLimitFlg=0;
    private int selfSalingFlg=0;
    private String tranOriginCode="Y003";
    private String clientCreateDate="";
    private String clientCreateBy="";
    private String clientUpdateDate="";
    private String clientUpdateBy="";
    private String signatureData="";
    private String modifyReasonCode="";
    private List<SubmitOrderList> orderItemList=new ArrayList<SubmitOrderList>();

    public String getTranCodeSRC() {
        return tranCodeSRC;
    }

    public void setTranCodeSRC(String tranCodeSRC) {
        this.tranCodeSRC = tranCodeSRC;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getUsageCode() {
        return usageCode;
    }

    public void setUsageCode(String usageCode) {
        this.usageCode = usageCode;
    }

    public String getStaffCode() {
        return staffCode;
    }

    public void setStaffCode(String staffCode) {
        this.staffCode = staffCode;
    }

    public String getDeliveryInstructions() {
        return deliveryInstructions;
    }

    public void setDeliveryInstructions(String deliveryInstructions) {
        this.deliveryInstructions = deliveryInstructions;
    }

    public String getDispatchInstructions() {
        return dispatchInstructions;
    }

    public void setDispatchInstructions(String dispatchInstructions) {
        this.dispatchInstructions = dispatchInstructions;
    }

    public String getSoldToNo() {
        return soldToNo;
    }

    public void setSoldToNo(String soldToNo) {
        this.soldToNo = soldToNo;
    }

    public String getShipToNo() {
        return shipToNo;
    }

    public void setShipToNo(String shipToNo) {
        this.shipToNo = shipToNo;
    }

    public int getActiveFlg() {
        return activeFlg;
    }

    public void setActiveFlg(int activeFlg) {
        this.activeFlg = activeFlg;
    }

    public String getCallingDate() {
        return callingDate;
    }

    public void setCallingDate(String callingDate) {
        this.callingDate = callingDate;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public int getUseAdvancedpayment() {
        return useAdvancedpayment;
    }

    public void setUseAdvancedpayment(int useAdvancedpayment) {
        this.useAdvancedpayment = useAdvancedpayment;
    }

    public String getTranCodeExternal() {
        return tranCodeExternal;
    }

    public void setTranCodeExternal(String tranCodeExternal) {
        this.tranCodeExternal = tranCodeExternal;
    }

    public int getDirectshipCode() {
        return directshipCode;
    }

    public void setDirectshipCode(int directshipCode) {
        this.directshipCode = directshipCode;
    }

    public int getAutoreleaseLimitFlg() {
        return autoreleaseLimitFlg;
    }

    public void setAutoreleaseLimitFlg(int autoreleaseLimitFlg) {
        this.autoreleaseLimitFlg = autoreleaseLimitFlg;
    }

    public int getSelfSalingFlg() {
        return selfSalingFlg;
    }

    public void setSelfSalingFlg(int selfSalingFlg) {
        this.selfSalingFlg = selfSalingFlg;
    }

    public String getTranOriginCode() {
        return tranOriginCode;
    }

    public void setTranOriginCode(String tranOriginCode) {
        this.tranOriginCode = tranOriginCode;
    }

    public String getClientCreateDate() {
        return clientCreateDate;
    }

    public void setClientCreateDate(String clientCreateDate) {
        this.clientCreateDate = clientCreateDate;
    }

    public String getClientCreateBy() {
        return clientCreateBy;
    }

    public void setClientCreateBy(String clientCreateBy) {
        this.clientCreateBy = clientCreateBy;
    }

    public String getClientUpdateDate() {
        return clientUpdateDate;
    }

    public void setClientUpdateDate(String clientUpdateDate) {
        this.clientUpdateDate = clientUpdateDate;
    }

    public String getClientUpdateBy() {
        return clientUpdateBy;
    }

    public void setClientUpdateBy(String clientUpdateBy) {
        this.clientUpdateBy = clientUpdateBy;
    }

    public String getSignatureData() {
        return signatureData;
    }

    public void setSignatureData(String signatureData) {
        this.signatureData = signatureData;
    }

    public String getModifyReasonCode() {
        return modifyReasonCode;
    }

    public void setModifyReasonCode(String modifyReasonCode) {
        this.modifyReasonCode = modifyReasonCode;
    }

    public List<SubmitOrderList> getOrderItemList() {
        return orderItemList;
    }

    public void setOrderItemList(List<SubmitOrderList> orderItemList) {
        this.orderItemList = orderItemList;
    }
}
