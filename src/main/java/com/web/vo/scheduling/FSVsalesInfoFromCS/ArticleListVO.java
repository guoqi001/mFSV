package com.web.vo.scheduling.FSVsalesInfoFromCS;

/**
 * Created by jiangmq1 on 2017/5/24.
 */
public class ArticleListVO {
    private String articleNo;
    private  int actSalesCount;
    private  int refillCount;
    private  int redrawCount;
    private  int salesCount;

    public String getArticleNo() {
        return articleNo;
    }

    public void setArticleNo(String articleNo) {
        this.articleNo = articleNo;
    }

    public int getActSalesCount() {
        return actSalesCount;
    }

    public void setActSalesCount(int actSalesCount) {
        this.actSalesCount = actSalesCount;
    }

    public int getRefillCount() {
        return refillCount;
    }

    public void setRefillCount(int refillCount) {
        this.refillCount = refillCount;
    }

    public int getRedrawCount() {
        return redrawCount;
    }

    public void setRedrawCount(int redrawCount) {
        this.redrawCount = redrawCount;
    }

    public int getSalesCount() {
        return salesCount;
    }

    public void setSalesCount(int salesCount) {
        this.salesCount = salesCount;
    }
}
