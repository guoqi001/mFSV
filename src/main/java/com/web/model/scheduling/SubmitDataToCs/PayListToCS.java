package com.web.model.scheduling.SubmitDataToCs;

import com.alibaba.fastjson.annotation.JSONType;

/**
 * Created by jiangmq1 on 2017/5/25.
 */
@JSONType(orders = {"typeName","termNo","amount","num","colvAmount","updateReason"})
public class PayListToCS {
    private String typeName="";
    private String termNo="";
    private double amount=0;
    private int num=0;
    private double colvAmount=0;
    private String updateReason="";

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getTermNo() {
        return termNo;
    }

    public void setTermNo(String termNo) {
        this.termNo = termNo;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public double getColvAmount() {
        return colvAmount;
    }

    public void setColvAmount(double colvAmount) {
        this.colvAmount = colvAmount;
    }

    public String getUpdateReason() {
        return updateReason;
    }

    public void setUpdateReason(String updateReason) {
        this.updateReason = updateReason;
    }
}
