package com.web.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.web.model.inventory.GetTruckInventory;
import com.web.service.InventoryService;
import com.web.utils.util;
import com.web.vo.inventory.ArticleListVO;
import com.web.vo.inventory.GetTruckInventoryVO;
import com.web.vo.login.DriverPhoneVO;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by jiangmq1 on 2017/5/25.
 */
@Service("InventoryService")
public class InventoryServiceImpl implements InventoryService {

    public GetTruckInventoryVO getTruckInventory(HttpSession session) {
        DriverPhoneVO driverPhoneVO= (DriverPhoneVO) session.getAttribute("driverPhoneVO");
        String outletNo=driverPhoneVO.getDriverNo();
        String token=driverPhoneVO.getToken();

        GetTruckInventory getTruckInventory=new GetTruckInventory();
        HttpClient httpClient = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost(util.getValue("url_cs")+"getTruckInventory");
        getTruckInventory.setToken(token);
        getTruckInventory.setDriverNo(outletNo);
        StringEntity entity = new StringEntity(JSON.toJSONString(getTruckInventory),"utf-8");
        httpPost.setHeader("Content-Type","application/json");
        httpPost.setEntity(entity);

        GetTruckInventoryVO getTruckInventoryVO = new GetTruckInventoryVO();
        //httpPost.setHeader("x-access-token","");
        try {
            HttpResponse response = httpClient.execute(httpPost);
            String result= EntityUtils.toString(response.getEntity(),"utf-8");
            JSONObject resultJson= JSON.parseObject(result);
            if("202".equals(resultJson.getString("status"))){
                getTruckInventoryVO.setStatus(202);
                getTruckInventoryVO.setMessage("未获取到库存数据");
            }else if("200".equals(resultJson.getString("status"))){
                getTruckInventoryVO.setStatus(200);
                JSONArray jsonArray = resultJson.getJSONArray("articleList");
                for(int i=0;i<jsonArray.size();i++){
                    ArticleListVO articleListVO=new ArticleListVO();
                    JSONObject object = JSON.parseObject(jsonArray.getString(i));
                    articleListVO.setArticleNo(object.getString("articleNo"));
                    articleListVO.setArticleName(object.getString("articleName"));
                    articleListVO.setOrderCases(object.getString("orderCases"));
                    articleListVO.setRefillCases(object.getString("refillCases"));
                    articleListVO.setRefillPieces(object.getString("refillPieces"));
                    articleListVO.setReturnCases(object.getString("returnCases"));
                    articleListVO.setReturnPieces(object.getString("returnPieces"));
                    getTruckInventoryVO.getArticleList().add(articleListVO);
                }
            }else if("500".equals(resultJson.getString("status"))){
                getTruckInventoryVO.setStatus(500);
                getTruckInventoryVO.setMessage("获取库存数据失败");
            }else{
                return null;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return getTruckInventoryVO;
    }
}
