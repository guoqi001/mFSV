package com.web.vo.inventory;

/**
 * Created by jiangmq1 on 2017/5/25.
 */
public class ArticleListVO {
    private String articleNo;
    private String articleName;
    private String orderCases;
    private String refillCases;
    private String refillPieces;
    private String returnCases;
    private String returnPieces;

    public String getArticleNo() {
        return articleNo;
    }

    public void setArticleNo(String articleNo) {
        this.articleNo = articleNo;
    }

    public String getArticleName() {
        return articleName;
    }

    public void setArticleName(String articleName) {
        this.articleName = articleName;
    }

    public String getOrderCases() {
        return orderCases;
    }

    public void setOrderCases(String orderCases) {
        this.orderCases = orderCases;
    }

    public String getRefillCases() {
        return refillCases;
    }

    public void setRefillCases(String refillCases) {
        this.refillCases = refillCases;
    }

    public String getRefillPieces() {
        return refillPieces;
    }

    public void setRefillPieces(String refillPieces) {
        this.refillPieces = refillPieces;
    }

    public String getReturnCases() {
        return returnCases;
    }

    public void setReturnCases(String returnCases) {
        this.returnCases = returnCases;
    }

    public String getReturnPieces() {
        return returnPieces;
    }

    public void setReturnPieces(String returnPieces) {
        this.returnPieces = returnPieces;
    }
}
