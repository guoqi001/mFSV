package com.web.vo.scheduling;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jiangmq1 on 2017/5/23.
 */
public class GetDriverOutletVO {
    private int status;
    private List<OutletListVO> outletList=new ArrayList<OutletListVO>();
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

    public List<OutletListVO> getOutletList() {
        return outletList;
    }

    public void setOutletList(List<OutletListVO> outletList) {
        this.outletList = outletList;
    }
}
