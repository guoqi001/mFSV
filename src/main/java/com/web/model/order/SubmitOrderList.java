package com.web.model.order;

import com.alibaba.fastjson.annotation.JSONType;

/**
 * Created by jiangmq1 on 2017/5/18.
 */
@JSONType(orders = {"tranCodeSRC","itemNo","articleNo","cases","pieces","articlePrice","articlePriceAmount","defectiveReasonCode"})
public class SubmitOrderList {
    private String tranCodeSRC="";
    private int itemNo;
    private String articleNo="";
    private int cases;
    private int pieces=0;
    private double articlePrice=0;
    private double articlePriceAmount=0;
    private String defectiveReasonCode="";

    public String getTranCodeSRC() {
        return tranCodeSRC;
    }

    public void setTranCodeSRC(String tranCodeSRC) {
        this.tranCodeSRC = tranCodeSRC;
    }

    public int getItemNo() {
        return itemNo;
    }

    public void setItemNo(int itemNo) {
        this.itemNo = itemNo;
    }

    public String getArticleNo() {
        return articleNo;
    }

    public void setArticleNo(String articleNo) {
        this.articleNo = articleNo;
    }

    public int getCases() {
        return cases;
    }

    public void setCases(int cases) {
        this.cases = cases;
    }

    public int getPieces() {
        return pieces;
    }

    public void setPieces(int pieces) {
        this.pieces = pieces;
    }

    public double getArticlePrice() {
        return articlePrice;
    }

    public void setArticlePrice(double articlePrice) {
        this.articlePrice = articlePrice;
    }

    public double getArticlePriceAmount() {
        return articlePriceAmount;
    }

    public void setArticlePriceAmount(double articlePriceAmount) {
        this.articlePriceAmount = articlePriceAmount;
    }

    public String getDefectiveReasonCode() {
        return defectiveReasonCode;
    }

    public void setDefectiveReasonCode(String defectiveReasonCode) {
        this.defectiveReasonCode = defectiveReasonCode;
    }


            ;
}
