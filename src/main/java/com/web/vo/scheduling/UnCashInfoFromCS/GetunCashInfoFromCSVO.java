package com.web.vo.scheduling.UnCashInfoFromCS;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jiangmq1 on 2017/5/25.
 */
public class GetunCashInfoFromCSVO {
    private int status;
    private List<OptListVO> optList=new ArrayList<OptListVO>();
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

    public List<OptListVO> getOptList() {
        return optList;
    }

    public void setOptList(List<OptListVO> optList) {
        this.optList = optList;
    }
}
