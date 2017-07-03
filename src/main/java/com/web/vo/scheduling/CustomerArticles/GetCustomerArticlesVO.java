package com.web.vo.scheduling.CustomerArticles;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jiangmq1 on 2017/5/25.
 */
public class GetCustomerArticlesVO {
    private int status;
    private List<ArticlesVO> articles=new ArrayList<ArticlesVO>();
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

    public List<ArticlesVO> getArticles() {
        return articles;
    }

    public void setArticles(List<ArticlesVO> articles) {
        this.articles = articles;
    }
}
