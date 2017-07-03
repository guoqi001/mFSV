package com.web.model.order;

/**
 * Created by jiangmq1 on 2017/5/26.
 */
public class GetDriverMessage {
    private String tranCodeSrc;
    private String driverNo;

    public String getDriverNo() {
        return driverNo;
    }

    public void setDriverNo(String driverNo) {
        this.driverNo = driverNo;
    }

    public String getTranCodeSrc() {
        return tranCodeSrc;
    }

    public void setTranCodeSrc(String tranCodeSrc) {
        this.tranCodeSrc = tranCodeSrc;
    }
}
