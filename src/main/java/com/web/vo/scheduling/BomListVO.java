package com.web.vo.scheduling;

/**
 * Created by jiangmq1 on 2017/5/23.
 */
public class BomListVO {
    private String BomNo;
    private String BomName;
    private int quantity;

    public String getBomNo() {
        return BomNo;
    }

    public void setBomNo(String bomNo) {
        BomNo = bomNo;
    }

    public String getBomName() {
        return BomName;
    }

    public void setBomName(String bomName) {
        BomName = bomName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
