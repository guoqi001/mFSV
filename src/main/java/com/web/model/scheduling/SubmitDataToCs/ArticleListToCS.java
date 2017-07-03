package com.web.model.scheduling.SubmitDataToCs;

import com.alibaba.fastjson.annotation.JSONType;

/**
 * Created by jiangmq1 on 2017/5/25.
 */
@JSONType(orders = {"articleNo","salesNum","reaSalesNum","refillNum","returnNum"})
public class ArticleListToCS {
    private String articleNo="";
//    private String articleName="";
    private int salesNum=0;
    private int reaSalesNum=0;
    private int refillNum=0;
    private int returnNum=0;

//    public String getArticleName() {
//        return articleName;
//    }
//
//    public void setArticleName(String articleName) {
//        this.articleName = articleName;
//    }

    public String getArticleNo() {
        return articleNo;
    }

    public void setArticleNo(String articleNo) {
        this.articleNo = articleNo;
    }

    public int getSalesNum() {
        return salesNum;
    }

    public void setSalesNum(int salesNum) {
        this.salesNum = salesNum;
    }

    public int getReaSalesNum() {
        return reaSalesNum;
    }

    public void setReaSalesNum(int reaSalesNum) {
        this.reaSalesNum = reaSalesNum;
    }

    public int getRefillNum() {
        return refillNum;
    }

    public void setRefillNum(int refillNum) {
        this.refillNum = refillNum;
    }

    public int getReturnNum() {
        return returnNum;
    }

    public void setReturnNum(int returnNum) {
        this.returnNum = returnNum;
    }
}
