package com.web.vo.scheduling.FSVsalesInfoFromCS;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jiangmq1 on 2017/5/24.
 */
public class GetFSVsalesInfoFromCSVO {
    private int status;
    private List<ArticleListVO> articleList=new ArrayList<ArticleListVO>();
    private int machineNum;
    private int fsvDeposit;
    private int refillType;
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

    public List<ArticleListVO> getArticleList() {
        return articleList;
    }

    public void setArticleList(List<ArticleListVO> articleList) {
        this.articleList = articleList;
    }

    public int getMachineNum() {
        return machineNum;
    }

    public void setMachineNum(int machineNum) {
        this.machineNum = machineNum;
    }

    public int getFsvDeposit() {
        return fsvDeposit;
    }

    public void setFsvDeposit(int fsvDeposit) {
        this.fsvDeposit = fsvDeposit;
    }

    public int getRefillType() {
        return refillType;
    }

    public void setRefillType(int refillType) {
        this.refillType = refillType;
    }
}
