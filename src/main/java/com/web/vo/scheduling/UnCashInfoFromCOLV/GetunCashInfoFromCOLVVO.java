package com.web.vo.scheduling.UnCashInfoFromCOLV;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jiangmq1 on 2017/5/24.
 */
public class GetunCashInfoFromCOLVVO {
    private int status;
    private String shipmentCode;
    private List<OptlistVO> optlist=new ArrayList<OptlistVO>();
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

    public String getShipmentCode() {
        return shipmentCode;
    }

    public void setShipmentCode(String shipmentCode) {
        this.shipmentCode = shipmentCode;
    }

    public List<OptlistVO> getOptlist() {
        return optlist;
    }

    public void setOptlist(List<OptlistVO> optlist) {
        this.optlist = optlist;
    }
}
