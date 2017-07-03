package com.web.model.scheduling.SubmitDataToCs;

import com.alibaba.fastjson.annotation.JSONType;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jiangmq1 on 2017/5/25.
 */
@JSONType(orders = {"token","shipmentCode","outletNo","machineNum","fsvDeposit","refillType","articleList",
        "periodId","payList","deliverDate","lastDeliverDate","photoList","createDate","createBy","updateDate",
        "updateBy"})
public class SubmitrefillDataToCs {
    private String token="";
    private String shipmentCode="";
    private String outletNo="";
    private int machineNum=0;
    private double fsvDeposit=0;
    private int refillType=0;
    private List<ArticleListToCS> articleList=new ArrayList<ArticleListToCS>();
    private String periodId="";
    private List<PayListToCS> payList=new ArrayList<PayListToCS>();
    private String deliverDate="";
    private String lastDeliverDate="";
    private List<PhotoListToCS> photoList=new ArrayList<PhotoListToCS>();
    private String createDate="";
    private String createBy="";
    private String updateDate="";
    private String updateBy="";

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

    public String getOutletNo() {
        return outletNo;
    }

    public void setOutletNo(String outletNo) {
        this.outletNo = outletNo;
    }

    public int getMachineNum() {
        return machineNum;
    }

    public void setMachineNum(int machineNum) {
        this.machineNum = machineNum;
    }

    public double getFsvDeposit() {
        return fsvDeposit;
    }

    public void setFsvDeposit(double fsvDeposit) {
        this.fsvDeposit = fsvDeposit;
    }

    public int getRefillType() {
        return refillType;
    }

    public void setRefillType(int refillType) {
        this.refillType = refillType;
    }

    public List<ArticleListToCS> getArticleList() {
        return articleList;
    }

    public void setArticleList(List<ArticleListToCS> articleList) {
        this.articleList = articleList;
    }

    public String getPeriodId() {
        return periodId;
    }

    public void setPeriodId(String periodId) {
        this.periodId = periodId;
    }

    public List<PayListToCS> getPayList() {
        return payList;
    }

    public void setPayList(List<PayListToCS> payList) {
        this.payList = payList;
    }

    public String getDeliverDate() {
        return deliverDate;
    }

    public void setDeliverDate(String deliverDate) {
        this.deliverDate = deliverDate;
    }

    public String getLastDeliverDate() {
        return lastDeliverDate;
    }

    public void setLastDeliverDate(String lastDeliverDate) {
        this.lastDeliverDate = lastDeliverDate;
    }

    public List<PhotoListToCS> getPhotoList() {
        return photoList;
    }

    public void setPhotoList(List<PhotoListToCS> photoList) {
        this.photoList = photoList;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }
}
