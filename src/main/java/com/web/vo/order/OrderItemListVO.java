package com.web.vo.order;

/**
 * Created by jiangmq1 on 2017/5/18.
 */
public class OrderItemListVO {
    private String articleNo;
    private String freeFlg;
    private int cases;
    private int pieces;
    private String unit;
    private double productTotal;

    public String getArticleNo() {
        return articleNo;
    }

    public void setArticleNo(String articleNo) {
        this.articleNo = articleNo;
    }

    public String getFreeFlg() {
        return freeFlg;
    }

    public void setFreeFlg(String freeFlg) {
        this.freeFlg = freeFlg;
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

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public double getProductTotal() {
        return productTotal;
    }

    public void setProductTotal(double productTotal) {
        this.productTotal = productTotal;
    }
}
