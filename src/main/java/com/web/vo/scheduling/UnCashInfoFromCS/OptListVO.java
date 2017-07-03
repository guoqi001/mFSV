package com.web.vo.scheduling.UnCashInfoFromCS;

/**
 * Created by jiangmq1 on 2017/5/25.
 */
public class OptListVO {
    private String plat;
    private double amount;
    private double relAmount;
    private String termNo;
    private String deliverCycle;
    private String updateReason;
    private int count;

    public String getPlat() {
        return plat;
    }

    public void setPlat(String plat) {
        this.plat = plat;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getRelAmount() {
        return relAmount;
    }

    public void setRelAmount(double relAmount) {
        this.relAmount = relAmount;
    }

    public String getTermNo() {
        return termNo;
    }

    public void setTermNo(String termNo) {
        this.termNo = termNo;
    }

    public String getDeliverCycle() {
        return deliverCycle;
    }

    public void setDeliverCycle(String deliverCycle) {
        this.deliverCycle = deliverCycle;
    }

    public String getUpdateReason() {
        return updateReason;
    }

    public void setUpdateReason(String updateReason) {
        this.updateReason = updateReason;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
