package com.web.vo.scheduling;

/**
 * Created by jiangmq1 on 2017/5/23.
 */
public class GetMachineStatusVO {
    private int status;
    private String  oosFlag;
    private int damageFlag;
    private String colvFlag;
    private String lastDeliveryDate;
    private String message="";

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getOosFlag() {
        return oosFlag;
    }

    public void setOosFlag(String oosFlag) {
        this.oosFlag = oosFlag;
    }

    public int getDamageFlag() {
        return damageFlag;
    }

    public void setDamageFlag(int damageFlag) {
        this.damageFlag = damageFlag;
    }

    public String getColvFlag() {
        return colvFlag;
    }

    public void setColvFlag(String colvFlag) {
        this.colvFlag = colvFlag;
    }

    public String getLastDeliveryDate() {
        return lastDeliveryDate;
    }

    public void setLastDeliveryDate(String lastDeliveryDate) {
        this.lastDeliveryDate = lastDeliveryDate;
    }
}
