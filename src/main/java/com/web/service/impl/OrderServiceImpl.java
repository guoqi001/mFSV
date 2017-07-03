package com.web.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.web.model.order.*;
import com.web.service.OrderService;
import com.web.utils.util;
import com.web.vo.login.DriverPhoneVO;
import com.web.vo.order.*;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created by jiangmq1 on 2017/5/16.
 */
@Service("OrderService")
public class OrderServiceImpl implements OrderService{
    public OrderHeaderListVO getUnbillingOrderHeaderList(HttpSession session) {
        DriverPhoneVO driverPhoneVO= (DriverPhoneVO) session.getAttribute("driverPhoneVO");
        String outletNo=driverPhoneVO.getDriverNo();
        String token=driverPhoneVO.getToken();

        OrderHeaderList orderHeaderList=new OrderHeaderList();
        HttpClient httpClient = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost(util.getValue("url_fo")+"getUnbillingOrderHeaderList");
        orderHeaderList.setOutletNo(outletNo);
        orderHeaderList.setStartDate(util.getTimeForType());
        StringEntity entity = new StringEntity(JSON.toJSONString(orderHeaderList),"utf-8");
        httpPost.setHeader("Content-Type","application/json");
        httpPost.addHeader("x-access-token",token);
        httpPost.setEntity(entity);

        OrderHeaderListVO orderHeaderListVO = new OrderHeaderListVO();
        //httpPost.setHeader("x-access-token","");
        try {
            HttpResponse response = httpClient.execute(httpPost);
            String result= EntityUtils.toString(response.getEntity(),"utf-8");
            JSONObject resultJson= JSON.parseObject(result);
            if("202".equals(resultJson.getString("status"))){
                orderHeaderListVO.setStatus(202);
                orderHeaderListVO.setMessage("未获取到数据");
            }else if("200".equals(resultJson.getString("status"))){
                orderHeaderListVO.setStatus(200);
                JSONArray jsonArray = resultJson.getJSONArray("orderHeaderList");
                for(int i=0;i<jsonArray.size();i++){
                    HeaderListVO headerListVO=new HeaderListVO();
                    JSONObject object = JSON.parseObject(jsonArray.getString(i));
                    headerListVO.setFoTranCode(object.getString("foTranCode"));
                    headerListVO.setMysccTranCode(object.getString("mysccTranCode"));
                    headerListVO.setSapTranCode(object.getString("sapTranCode"));
                    headerListVO.setOrderDate(object.getString("orderDate"));
                    headerListVO.setPriceTotal(object.getDouble("priceTotal"));
                    headerListVO.setOninvoiceDiscountTotal(object.getDouble("oninvoiceDiscountTotal"));
                    headerListVO.setOffinvoiceDiscountTotal(object.getDouble("offinvoiceDiscountTotal"));
                    headerListVO.setDepositTotal(object.getDouble("depositTotal"));
                    headerListVO.setDocCode(object.getString("docCode"));
                    headerListVO.setReceiveDate(object.getString("receiveDate"));
                    headerListVO.setTranOriginCode(object.getString("tranOriginCode"));
                    headerListVO.setDeliveryFlg(object.getString("deliveryFlg"));
                    headerListVO.setUsageCode(object.getString("usageCode"));
                    headerListVO.setMainStatus(object.getString("mainStatus"));
                    headerListVO.setDirectshipStatus(object.getString("directshipStatus"));
                    orderHeaderListVO.getOrderHeaderList().add(headerListVO);
                }
            }else{
                return null;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return orderHeaderListVO;
    }

    public GetDriverMessageVO getDriverMessage(String TranCodeSrc, HttpSession session) {
        DriverPhoneVO driverPhoneVO= (DriverPhoneVO) session.getAttribute("driverPhoneVO");
        String token=driverPhoneVO.getToken();
        String driverNo=driverPhoneVO.getDriverNo();

        GetDriverMessage getDriverMessage=new GetDriverMessage();
        HttpClient httpClient = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost(util.getValue("url_fo")+"getDriverMessage");
        if(TranCodeSrc==null){
            TranCodeSrc="";
        }
        getDriverMessage.setTranCodeSrc(TranCodeSrc);
        getDriverMessage.setDriverNo(driverNo);
        StringEntity entity = new StringEntity(JSON.toJSONString(getDriverMessage),"utf-8");
        httpPost.setHeader("Content-Type","application/json");
        httpPost.addHeader("x-access-token",token);
        httpPost.setEntity(entity);

        GetDriverMessageVO getDriverMessageVO = new GetDriverMessageVO();
        //httpPost.setHeader("x-access-token","");
        try {
            HttpResponse response = httpClient.execute(httpPost);
            String result= EntityUtils.toString(response.getEntity(),"utf-8");
            JSONObject resultJson= JSON.parseObject(result);
            if(result!=null) {
                if ("202".equals(resultJson.getString("status"))) {
                    getDriverMessageVO.setStatus(202);
                    getDriverMessageVO.setMessage("未获取到数据");
                } else if ("200".equals(resultJson.getString("status"))) {
                    getDriverMessageVO.setStatus(200);
                    JSONArray jsonArray = resultJson.getJSONArray("messageList");
                    for (int i = 0; i < jsonArray.size(); i++) {
                        MessageListVO messageListVO = new MessageListVO();
                        JSONObject object = JSON.parseObject(jsonArray.getString(i));
                        messageListVO.setMessageText(object.getString("messageText"));
                        messageListVO.setCreateDate(object.getString("createDate"));
                        getDriverMessageVO.getMessageList().add(messageListVO);
                    }
                } else {
                    return null;
                }
            }else{
                return null;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return getDriverMessageVO;
    }

    public GetAllProductsVO getAllProducts(HttpSession session) {
        DriverPhoneVO driverPhoneVO= (DriverPhoneVO) session.getAttribute("driverPhoneVO");
        String token="";
        if(driverPhoneVO!=null){
            token=driverPhoneVO.getToken();
        }
        HttpGet httpGet=new HttpGet(util.getValue("url_fo")+"getAllProductsByCompany");
        httpGet.setHeader("Content-Type","application/json");
        httpGet.addHeader("x-access-token",token);
        String result= "";
        GetAllProductsVO getAllProductsVO=new GetAllProductsVO();
        try {
            HttpResponse httpResponse = new DefaultHttpClient().execute(httpGet);
            if(httpResponse.getStatusLine().getStatusCode() == 200)
            {
                HttpEntity httpEntity = httpResponse.getEntity();
                result = EntityUtils.toString(httpEntity,"utf-8");//取出应答字符串
                // 一般来说都要删除多余的字符
                result.replaceAll("\r", "");//去掉返回结果中的"\r"字符，否则会在结果字符串后面显示一个小方格
            }
            else
                httpGet.abort();

            JSONObject resultJson= JSON.parseObject(result);
            if("202".equals(resultJson.getString("status"))){
                getAllProductsVO.setStatus(202);
                getAllProductsVO.setMessage("未获取到数据");
            }else if("200".equals(resultJson.getString("status"))){
                getAllProductsVO.setStatus(200);
                JSONArray jsonArray = resultJson.getJSONArray("articleList");
                for(int i=0;i<jsonArray.size();i++){
                    ArticleListVO articleListVO=new ArticleListVO();
                    JSONObject object = JSON.parseObject(jsonArray.getString(i));
                    articleListVO.setArticleNo(object.getString("articleNo"));
                    articleListVO.setArticleName(object.getString("articleName"));
                    articleListVO.setArticleNameEn(object.getString("articleNameEn"));
                    articleListVO.setArticleThumb(object.getString("articleThumb"));
                    articleListVO.setArticleUnit(object.getInteger("articleUnit"));
                    articleListVO.setArticlePkgType(object.getString("articlePkgType"));
                    articleListVO.setCategoryCode(object.getString("categoryCode"));
                    articleListVO.setUPC(object.getString("UPC"));
                    articleListVO.setArticleStdConvert(object.getDouble("articleStdConvert"));
                    articleListVO.setMinUnit(object.getInteger("minUnit"));
                    articleListVO.setMaterialType(object.getString("materialType"));
                    articleListVO.setFlavorCode(object.getString("flavorCode"));
                    articleListVO.setArticleBrand(object.getString("articleBrand"));
                    articleListVO.setPackageGroup(object.getString("packageGroup"));
                    articleListVO.setPackageSize(object.getString("packageSize"));
                    articleListVO.setActiveFlg(object.getString("activeFlg"));
                    getAllProductsVO.getArticleList().add(articleListVO);
                }
            }else{
                return null;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return getAllProductsVO;
    }

    public OrderItemsVO getUnbillingOrderDetail(String foTranCode, HttpSession session) {
        DriverPhoneVO driverPhoneVO= (DriverPhoneVO) session.getAttribute("driverPhoneVO");
        String token=driverPhoneVO.getToken();

        HttpGet httpGet=new HttpGet(util.getValue("url_fo")+"getUnbillingOrderDetail/"+foTranCode);
        httpGet.setHeader("Content-Type","application/json");
        httpGet.addHeader("x-access-token",token);
        String result= "";
        OrderItemsVO orderItemsVO = new OrderItemsVO();
        try {
            HttpResponse httpResponse = new DefaultHttpClient().execute(httpGet);
            if(httpResponse.getStatusLine().getStatusCode() == 200)
            {
                HttpEntity httpEntity = httpResponse.getEntity();
                result = EntityUtils.toString(httpEntity,"utf-8");//取出应答字符串
                // 一般来说都要删除多余的字符
                result.replaceAll("\r", "");//去掉返回结果中的"\r"字符，否则会在结果字符串后面显示一个小方格
            }
            else
                httpGet.abort();

            JSONObject resultJson= JSON.parseObject(result);
            if("202".equals(resultJson.getString("status"))){
                orderItemsVO.setStatus(202);
                orderItemsVO.setMessage("未获取到数据");
            }else if("200".equals(resultJson.getString("status"))){
                orderItemsVO.setStatus(200);
                JSONArray jsonArray = resultJson.getJSONArray("orderItemList");
                for(int i=0;i<jsonArray.size();i++){
                    OrderItemListVO orderItemListVO = new OrderItemListVO();
                    JSONObject object = JSON.parseObject(jsonArray.getString(i));
                    orderItemListVO.setArticleNo(object.getString("articleNo"));
                    orderItemListVO.setFreeFlg(object.getString("freeFlg"));
                    orderItemListVO.setCases(object.getInteger("cases"));
                    orderItemListVO.setPieces(object.getInteger("pieces"));
                    orderItemListVO.setUnit(object.getString("unit"));
                    orderItemListVO.setProductTotal(object.getDouble("productTotal"));
                    orderItemsVO.getOrderItemList().add(orderItemListVO);
                }
            }else{
                return null;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return orderItemsVO;
    }

    public SubmitOrderVO submitOrder(String tranCodeSRC, String orderItemList, HttpSession session) {
        DriverPhoneVO driverPhoneVO= (DriverPhoneVO) session.getAttribute("driverPhoneVO");
        String token=driverPhoneVO.getToken();
        String driverNo=driverPhoneVO.getDriverNo();

        SubmitOrder submitOrder=new SubmitOrder();
        HttpClient httpClient = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost(util.getValue("url_fo")+"submitOrder");
        submitOrder.setTranCodeSRC(tranCodeSRC);
        submitOrder.setSoldToNo(driverNo);
        submitOrder.setShipToNo(driverNo);
        submitOrder.setCallingDate(util.getTime().substring(0,8));
        submitOrder.setDeliveryDate(util.getMoreTime());
        submitOrder.setClientCreateDate(util.getTime());
        submitOrder.setClientUpdateDate(util.getTime());

        JSONArray jsonArray=JSON.parseArray(orderItemList);
        for(int i=0;i<jsonArray.size();i++){
            JSONObject jsonObject=jsonArray.getJSONObject(i);
            if(jsonObject.getInteger("cases")==0){
                continue;
            }else {
                SubmitOrderList orderList = new SubmitOrderList();
                orderList.setTranCodeSRC(tranCodeSRC);
                orderList.setItemNo(jsonObject.getInteger("itemNo"));
                orderList.setArticleNo(jsonObject.getString("articleNo"));
                orderList.setCases(jsonObject.getInteger("cases"));
                orderList.setPieces(jsonObject.getInteger("pieces"));
                orderList.setArticlePrice(jsonObject.getInteger("articlePrice"));
                orderList.setArticlePriceAmount(jsonObject.getInteger("articlePriceAmount"));
                orderList.setDefectiveReasonCode(jsonObject.getString("defectiveReasonCode"));
                submitOrder.getOrderItemList().add(orderList);
            }
        }
        SubmitOrderVO submitOrderVO=new SubmitOrderVO();
        String order= String.valueOf(submitOrder.getOrderItemList());
        if("[]".equals(order)){
            submitOrderVO.setStatus(400);
            submitOrderVO.setMessage("订单无效，箱数不能为零");
            return submitOrderVO;
        }
        String json=JSON.toJSONString(submitOrder);
        StringEntity entity = new StringEntity(JSON.toJSONString(submitOrder),"utf-8");
        httpPost.setHeader("Content-Type","application/json");
        httpPost.addHeader("x-access-token",token);
        httpPost.setEntity(entity);
        try {
            HttpResponse response = httpClient.execute(httpPost);
            String result= EntityUtils.toString(response.getEntity(),"utf-8");
            JSONObject resultJson= JSON.parseObject(result);
            if(!"200".equals(resultJson.getString("status"))){
                return null;
            }else{
                submitOrderVO.setStatus(200);
                submitOrderVO.setResult(resultJson.getInteger("result"));
                submitOrderVO.setMessage(resultJson.getString("message"));
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return submitOrderVO;
    }

    public GetFSVProductsVO getFSVProducts(HttpSession session) {
        DriverPhoneVO driverPhoneVO= (DriverPhoneVO) session.getAttribute("driverPhoneVO");
        String token=driverPhoneVO.getToken();

        HttpGet httpGet=new HttpGet(util.getValue("url_fo")+"getFSVProductsByCompany");
        httpGet.setHeader("Content-Type","application/json");
        httpGet.addHeader("X-Access-Token",token);
        String result= "";
        GetFSVProductsVO getFSVProductsVO=new GetFSVProductsVO();
        try {
            HttpResponse httpResponse = new DefaultHttpClient().execute(httpGet);
            if(httpResponse.getStatusLine().getStatusCode() == 200)
            {
                HttpEntity httpEntity = httpResponse.getEntity();
                result = EntityUtils.toString(httpEntity,"utf-8");//取出应答字符串
                // 一般来说都要删除多余的字符
                result.replaceAll("\r", "");//去掉返回结果中的"\r"字符，否则会在结果字符串后面显示一个小方格
            }
            else
                httpGet.abort();

            JSONObject resultJson= JSON.parseObject(result);
            if("202".equals(resultJson.getString("status"))){
                getFSVProductsVO.setStatus(202);
                getFSVProductsVO.setMessage("未获取到数据");
            }else if("200".equals(resultJson.getString("status"))){
                getFSVProductsVO.setStatus(200);
                JSONArray jsonArray = resultJson.getJSONArray("articleList");
                for(int i=0;i<jsonArray.size();i++){
                    FSVArticleListVO fsvArticleListVO=new FSVArticleListVO();
                    JSONObject object = JSON.parseObject(jsonArray.getString(i));
                    fsvArticleListVO.setArticleNo(object.getString("articleNo"));
                    fsvArticleListVO.setArticleName(object.getString("articleName"));
                    getFSVProductsVO.getArticleList().add(fsvArticleListVO);
                }
            }else{
                return null;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return getFSVProductsVO;
    }
}
