package com.web.vo.order;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jiangmq1 on 2017/5/18.
 */
public class GetAllProductsVO {
    private int status;
    private List<ArticleListVO> articleList =new ArrayList<ArticleListVO>();
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
}
