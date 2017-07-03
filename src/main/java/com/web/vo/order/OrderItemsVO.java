package com.web.vo.order;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jiangmq1 on 2017/5/18.
 */
public class OrderItemsVO {
    private int status;
    private List<OrderItemListVO> orderItemList=new ArrayList<OrderItemListVO>();
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

    public List<OrderItemListVO> getOrderItemList() {
        return orderItemList;
    }

    public void setOrderItemList(List<OrderItemListVO> orderItemList) {
        this.orderItemList = orderItemList;
    }
}
