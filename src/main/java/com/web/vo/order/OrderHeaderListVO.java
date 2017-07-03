package com.web.vo.order;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jiangmq1 on 2017/5/17.
 */
public class OrderHeaderListVO {
    private int status;
    private List<HeaderListVO> orderHeaderList=new ArrayList<HeaderListVO>();
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

    public List<HeaderListVO> getOrderHeaderList() {
        return orderHeaderList;
    }

    public void setOrderHeaderList(List<HeaderListVO> orderHeaderList) {
        this.orderHeaderList = orderHeaderList;
    }
}
