package com.web.vo.scheduling;

/**
 * Created by jiangmq1 on 2017/5/23.
 */
public class OutletListVO {
    private String outletNo;
    private String outletName;
    private String outletAddress;
    private String outletChannel;
    private String refillFlag;

    public String getOutletNo() {
        return outletNo;
    }

    public void setOutletNo(String outletNo) {
        this.outletNo = outletNo;
    }

    public String getOutletName() {
        return outletName;
    }

    public void setOutletName(String outletName) {
        this.outletName = outletName;
    }

    public String getOutletAddress() {
        return outletAddress;
    }

    public void setOutletAddress(String outletAddress) {
        this.outletAddress = outletAddress;
    }

    public String getOutletChannel() {
        return outletChannel;
    }

    public void setOutletChannel(String outletChannel) {
        this.outletChannel = outletChannel;
    }

    public String getRefillFlag() {
        return refillFlag;
    }

    public void setRefillFlag(String refillFlag) {
        this.refillFlag = refillFlag;
    }
}
