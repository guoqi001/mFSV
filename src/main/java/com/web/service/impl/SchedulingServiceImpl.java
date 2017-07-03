package com.web.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.web.model.scheduling.*;
import com.web.model.scheduling.SubmitDataToCs.ArticleListToCS;
import com.web.model.scheduling.SubmitDataToCs.PayListToCS;
import com.web.model.scheduling.SubmitDataToCs.PhotoListToCS;
import com.web.model.scheduling.SubmitDataToCs.SubmitrefillDataToCs;
import com.web.service.SchedulingService;
import com.web.utils.util;
import com.web.vo.scheduling.*;
import com.web.vo.login.DriverPhoneVO;
import com.web.vo.scheduling.CustomerArticles.ArticlesVO;
import com.web.vo.scheduling.CustomerArticles.GetCustomerArticlesVO;
import com.web.vo.scheduling.CustomerProfile.GetCustomerProfileVO;
import com.web.vo.scheduling.FSVsalesInfoFromCOLV.ArticleListVO;
import com.web.vo.scheduling.FSVsalesInfoFromCOLV.GetFSVsalesInfoFromCOLVVO;
import com.web.vo.scheduling.FSVsalesInfoFromCS.GetFSVsalesInfoFromCSVO;
import com.web.vo.scheduling.UnCashInfoFromCOLV.GetunCashInfoFromCOLVVO;
import com.web.vo.scheduling.UnCashInfoFromCS.GetunCashInfoFromCSVO;
import com.web.vo.scheduling.UnCashInfoFromCS.OptListVO;
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
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by jiangmq1 on 2017/5/22.
 */
@Service("SchedulingService")
public class SchedulingServiceImpl implements SchedulingService{

    public GetShipmentListVO getShipmentList(HttpSession session) {

        DriverPhoneVO driverPhoneVO= (DriverPhoneVO) session.getAttribute("driverPhoneVO");
        String outletNo=driverPhoneVO.getDriverNo();
        String token=driverPhoneVO.getToken();

        GetShipmentList getShipmentList=new GetShipmentList();
        HttpClient httpClient = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost(util.getValue("url_cs")+"getShipmentList");
        getShipmentList.setDriverNo(outletNo);
        getShipmentList.setToken(token);
        StringEntity entity = new StringEntity(JSON.toJSONString(getShipmentList),"utf-8");
        httpPost.setHeader("Content-Type","application/json");
        httpPost.setEntity(entity);

        GetShipmentListVO getShipmentListVO = new GetShipmentListVO();
        //httpPost.setHeader("x-access-token","");
        try {
            HttpResponse response = httpClient.execute(httpPost);
            String result= EntityUtils.toString(response.getEntity(),"utf-8");
            JSONObject resultJson= JSON.parseObject(result);
            if("202".equals(resultJson.getString("status"))){
                getShipmentListVO.setStatus(202);
                getShipmentListVO.setMessageText("未获取到数据");
            }else if("200".equals(resultJson.getString("status"))){
                getShipmentListVO.setStatus(200);
                JSONArray jsonArray = resultJson.getJSONArray("shipmentList");
                for(int i=0;i<jsonArray.size();i++){
                    ShipmentListVO shipmentListVO=new ShipmentListVO();
                    JSONObject object = JSON.parseObject(jsonArray.getString(i));
                    shipmentListVO.setShipmentCode(object.getString("shipmentCode"));
                    shipmentListVO.setDeliveryDate(object.getString("deliveryDate"));
                    shipmentListVO.setOrderCount(object.getInteger("orderCount"));
                    shipmentListVO.setDeliveryStatus(object.getInteger("deliveryStatus"));
                    shipmentListVO.setDeliveryStatusDesc(object.getString("deliveryStatusDesc"));
                    shipmentListVO.setIsTransShipment(object.getInteger("isTransShipment"));
                    getShipmentListVO.getShipmentList().add(shipmentListVO);
                }
            }else{
                return null;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return getShipmentListVO;
    }

    public ConfirmVO CSConfirm(String shipmentCode, Integer csConfirm, HttpSession session) {
        DriverPhoneVO driverPhoneVO= (DriverPhoneVO) session.getAttribute("driverPhoneVO");
        String token=driverPhoneVO.getToken();

        CSConfirm csConfirm1=new CSConfirm();
        HttpClient httpClient = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost(util.getValue("url_cs")+"CSConfirm");
        csConfirm1.setToken(token);
        csConfirm1.setShipmentCode(shipmentCode);
        csConfirm1.setCsConfirm(csConfirm);
        String json=JSON.toJSONString(csConfirm1);
        StringEntity entity = new StringEntity(JSON.toJSONString(csConfirm1),"utf-8");
        httpPost.setHeader("Content-Type","application/json");
        httpPost.setEntity(entity);

        ConfirmVO confirmVO = new ConfirmVO();
        //httpPost.setHeader("x-access-token","");
        try {
            HttpResponse response = httpClient.execute(httpPost);
            String result= EntityUtils.toString(response.getEntity(),"utf-8");
            JSONObject resultJson= JSON.parseObject(result);
            if("500".equals(resultJson.getString("status"))){
                confirmVO.setStatus(500);
                confirmVO.setMessageId(resultJson.getInteger("messageId"));
                confirmVO.setMessageText(resultJson.getString("messageText"));
            }else if("200".equals(resultJson.getString("status"))){
                confirmVO.setStatus(200);
                confirmVO.setMessageId(resultJson.getInteger("messageId"));
                confirmVO.setMessageText(resultJson.getString("messageText"));
            }else{
                return null;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return confirmVO;
    }

    public GetDriverOutletVO getDriverOutlet(String shipmentCode, HttpSession session) {
        DriverPhoneVO driverPhoneVO= (DriverPhoneVO) session.getAttribute("driverPhoneVO");
        String outletNo=driverPhoneVO.getDriverNo();
        String token=driverPhoneVO.getToken();

        GetDriverOutlet getDriverOutlet=new GetDriverOutlet();
        HttpClient httpClient = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost(util.getValue("url_fo")+"getDriverOutelt");
        getDriverOutlet.setShipmentCode(shipmentCode);
        getDriverOutlet.setDriverNo(outletNo);
        StringEntity entity = new StringEntity(JSON.toJSONString(getDriverOutlet),"utf-8");
        httpPost.setHeader("Content-Type","application/json");
        httpPost.addHeader("x-access-token",token);
        httpPost.setEntity(entity);

        GetDriverOutletVO getDriverOutletVO = new GetDriverOutletVO();
        //httpPost.setHeader("x-access-token","");
        try {
            HttpResponse response = httpClient.execute(httpPost);
            String result= EntityUtils.toString(response.getEntity(),"utf-8");
            JSONObject resultJson= JSON.parseObject(result);
            if("202".equals(resultJson.getString("status"))){
                getDriverOutletVO.setStatus(202);
                getDriverOutletVO.setMessage("未获取到数据");
            }else if("200".equals(resultJson.getString("status"))){
                getDriverOutletVO.setStatus(200);
                JSONArray jsonArray = resultJson.getJSONArray("outletList");
                for(int i=0;i<jsonArray.size();i++){
                    OutletListVO outletListVO=new OutletListVO();
                    JSONObject object = JSON.parseObject(jsonArray.getString(i));
                    outletListVO.setOutletNo(object.getString("outletNo"));
                    outletListVO.setOutletName(object.getString("outletName"));
                    outletListVO.setOutletAddress(object.getString("outletAddress"));
                    outletListVO.setOutletChannel(object.getString("outletChannel"));
                    outletListVO.setRefillFlag(object.getString("refillFlag"));
                    getDriverOutletVO.getOutletList().add(outletListVO);
                }
            }else{
                return null;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return getDriverOutletVO;
    }

    public String getCustomerDeviceList(String outletNo,HttpSession session) {
        DriverPhoneVO driverPhoneVO= (DriverPhoneVO) session.getAttribute("driverPhoneVO");
        String token=driverPhoneVO.getToken();

        HttpGet httpGet=new HttpGet(util.getValue("url_fo")+"getCustomerDeviceListByCustomerId?outletNo="+outletNo);
        httpGet.setHeader("Content-Type","application/json");
        httpGet.addHeader("x-access-token",token);
        String result= "";
        GetCustomerDeviceListVO getCustomerDeviceListVO = new GetCustomerDeviceListVO();
        //httpPost.setHeader("x-access-token","");
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
                getCustomerDeviceListVO.setStatus(202);
                getCustomerDeviceListVO.setMessage("未获取到数据");
                Object array =  JSONArray.toJSON(getCustomerDeviceListVO);
                result=array.toString();
            }else if("200".equals(resultJson.getString("status"))){
                return result;
            }else{
                return null;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return result;
    }

    public GetMachineStatusVO getMachineStatus(String outletNo,HttpSession session) throws IOException {

        GetMachineStatusVO getMachineStatusVO=new GetMachineStatusVO();

        String colv_session= (String) session.getAttribute("colv_session");
        if(colv_session==null){
            colv_session="";
        }
        URL postUrl = new URL(util.getValue("url_colv"));
        HttpURLConnection connection = (HttpURLConnection) postUrl.openConnection();
        connection.setDoOutput(true);
        connection.setDoInput(true);
        connection.setRequestMethod("POST");
        connection.setUseCaches(false);
        connection.setInstanceFollowRedirects(true);
// 进行编码
        connection.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
        connection.connect();
        DataOutputStream out = new DataOutputStream(connection.getOutputStream());
        String content="rest_data={\"session\":\""+colv_session+"\",\"outletNo\":\""+outletNo+"\"}&method=getMachineStatus&input_type=JSON&response_type=JSON";
        out.writeBytes(content);
        out.flush();
        out.close();
        BufferedReader reader2  = new BufferedReader(new InputStreamReader(connection.getInputStream(),"utf-8"));//设置编码,否则中文乱码
        String line2="";
        while ((line2 = reader2.readLine()) != null){
//line = new String(line.getBytes(), "utf-8");
            JSONObject resultJson= JSON.parseObject(line2);
            if("202".equals(resultJson.getString("status"))){
                getMachineStatusVO.setStatus(202);
                getMachineStatusVO.setMessage("未获取到数据");
            }else if("200".equals(resultJson.getString("status"))){
                getMachineStatusVO.setStatus(200);
                if("正常".equals(resultJson.getString("oosFlag")))
                    getMachineStatusVO.setOosFlag("0");
                else if("缺货".equals(resultJson.getString("oosFlag")))
                    getMachineStatusVO.setOosFlag("1");
                else if("严重缺货".equals(resultJson.getString("oosFlag")))
                    getMachineStatusVO.setOosFlag("2");
                else
                    getMachineStatusVO.setOosFlag(resultJson.getString("oosFlag"));
                getMachineStatusVO.setDamageFlag(resultJson.getInteger("damageFlag"));
                getMachineStatusVO.setColvFlag(resultJson.getString("colvFlag"));
                getMachineStatusVO.setLastDeliveryDate(resultJson.getString("lastDeliveryDate"));
            }else{
                return  null;
            }
        }
        reader2.close();
        connection.disconnect();
        return getMachineStatusVO;
    }
    //带token有误
    public String getCustomerProfile(String outletNo, HttpSession session) {
        DriverPhoneVO driverPhoneVO= (DriverPhoneVO) session.getAttribute("driverPhoneVO");
        String token=driverPhoneVO.getToken();

        HttpGet httpGet=new HttpGet(util.getValue("url_fo")+"customerProfile/"+outletNo);
        httpGet.setHeader("Content-Type","application/json");
        httpGet.addHeader("x-access-token",token);
        String result=null;
        //httpPost.setHeader("x-access-token","");
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
            if(resultJson!=null){
                if("202".equals(resultJson.getString("status"))){
                    GetCustomerProfileVO getCustomerProfileVO=new GetCustomerProfileVO();
                    getCustomerProfileVO.setStatus(202);
                    getCustomerProfileVO.setMessage("未获取到数据");
                    Object array =  JSONArray.toJSON(getCustomerProfileVO);
                    result=array.toString();
                }else if("200".equals(resultJson.getString("status"))){
                    return result;
                }else{
                    return null;
                }
            }else{
                return null;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return result;
    }

    public String getunCashInfoFromCOLV(String shipmentCode,String outletNo,HttpSession session) throws IOException {
        String colv_session= (String) session.getAttribute("colv_session");
        if(colv_session==null){
            colv_session="";
        }
        URL postUrl = new URL(util.getValue("url_colv"));
// 打开连接
        HttpURLConnection connection = (HttpURLConnection) postUrl.openConnection();
        connection.setDoOutput(true);
        connection.setDoInput(true);
        connection.setRequestMethod("POST");
        connection.setUseCaches(false);
        connection.setInstanceFollowRedirects(true);
// 进行编码
        connection.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
        connection.connect();
        DataOutputStream out = new DataOutputStream(connection.getOutputStream());
        String content ="rest_data={\"session\":\""+colv_session+"\",\"outletNo\":\""+outletNo+"\",\"shipmentCode\":\""+shipmentCode+"\"}&method=getunCashInfoFromCOLV&input_type=JSON&response_type=JSON";
        out.writeBytes(content);
        out.flush();
        out.close(); // flush and close
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(),"utf-8"));//设置编码,否则中文乱码
        String line=null;
        String key="";
        while ((line = reader.readLine()) != null){
//line = new String(line.getBytes(), "utf-8");
            JSONObject resultJson= JSON.parseObject(line);
            if("202".equals(resultJson.getString("status"))){
                GetunCashInfoFromCOLVVO getunCashInfoFromCOLVVO=new GetunCashInfoFromCOLVVO();
                getunCashInfoFromCOLVVO.setStatus(202);
                getunCashInfoFromCOLVVO.setMessage("未获取到数据");
                Object array =  JSONArray.toJSON(getunCashInfoFromCOLVVO);
                return array.toString();
            }else if("200".equals(resultJson.getString("status"))){
                if("[]".equals(resultJson.getString("articleList"))){
                    GetunCashInfoFromCOLVVO getunCashInfoFromCOLVVO=new GetunCashInfoFromCOLVVO();
                    getunCashInfoFromCOLVVO.setStatus(202);
                    getunCashInfoFromCOLVVO.setMessage("未获取到数据");
                    Object array =  JSONArray.toJSON(getunCashInfoFromCOLVVO);
                    return array.toString();
                }else{
                    return line;
                }
            }else{
                return null;
            }
        }
        reader.close();
        connection.disconnect();
        return line;
    }

    public String getFSVsalesInfoFromCS(String shipmentCode,String outletNo, HttpSession session) {
        DriverPhoneVO driverPhoneVO= (DriverPhoneVO) session.getAttribute("driverPhoneVO");
        String token=driverPhoneVO.getToken();

        GetFSVsalesInfoFromCS getFSVsalesInfoFromCS=new GetFSVsalesInfoFromCS();
        HttpClient httpClient = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost(util.getValue("url_cs")+"getFSVsalesInfoFromCS");
        getFSVsalesInfoFromCS.setToken(token);
        getFSVsalesInfoFromCS.setShipmentcode(shipmentCode);
        getFSVsalesInfoFromCS.setOutletNo(outletNo);
        StringEntity entity = new StringEntity(JSON.toJSONString(getFSVsalesInfoFromCS),"utf-8");
        httpPost.setHeader("Content-Type","application/json");
        httpPost.setEntity(entity);
        String result=null;
        //httpPost.setHeader("x-access-token","");
        try {
            HttpResponse response = httpClient.execute(httpPost);
            result= EntityUtils.toString(response.getEntity(),"utf-8");
            JSONObject resultJson= JSON.parseObject(result);
            if("202".equals(resultJson.getString("status"))){
                GetFSVsalesInfoFromCSVO getFSVsalesInfoFromCSVO=new GetFSVsalesInfoFromCSVO();
                getFSVsalesInfoFromCSVO.setStatus(202);
                getFSVsalesInfoFromCSVO.setMessage("未获取到数据");
                Object array =  JSONArray.toJSON(getFSVsalesInfoFromCSVO);
                result=array.toString();
            }else if("200".equals(resultJson.getString("status"))){
                return result;
            }else{
                return null;
            }

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return result;
    }
//带token有误
    public GetCustomerArticlesVO getCustomerArticles(String outletNo,HttpSession session) {
        DriverPhoneVO driverPhoneVO= (DriverPhoneVO) session.getAttribute("driverPhoneVO");
        String token=driverPhoneVO.getToken();

        HttpGet httpGet=new HttpGet(util.getValue("url_fo")+"getCustomerArticles/"+outletNo);
        httpGet.setHeader("Content-Type","application/json");
        httpGet.addHeader("x-access-token",token);
        String result=null;
        GetCustomerArticlesVO getCustomerArticlesVO = new GetCustomerArticlesVO();
        //httpPost.setHeader("x-access-token","");
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
            if(result!=null) {
                JSONObject resultJson = JSON.parseObject(result);
                if("202".equals(resultJson.getString("status"))) {
                    getCustomerArticlesVO.setStatus(202);
                    getCustomerArticlesVO.setMessage("未获取到数据");
                }else if("200".equals(resultJson.getString("status"))){
                    getCustomerArticlesVO.setStatus(200);
                    JSONArray jsonArray = resultJson.getJSONArray("articles");
                    for (int i = 0; i < jsonArray.size(); i++) {
                        ArticlesVO articlesVO = new ArticlesVO();
                        JSONObject object = JSON.parseObject(jsonArray.getString(i));
                        articlesVO.setArticleNo(object.getString("articleNo"));
                        articlesVO.setPriceListPrice(object.getDouble("priceListPrice"));
                        getCustomerArticlesVO.getArticles().add(articlesVO);
                    }
                }else{
                    return null;
                }
            }else{
                return null;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return getCustomerArticlesVO;
    }

    public GetFSVsalesInfoFromCOLVVO getFSVsalesInfoFromCOLV(String shipmentCode,String outletNo,HttpSession session) throws IOException {

        String colv_session= (String) session.getAttribute("colv_session");
        if(colv_session==null){
            colv_session="";
        }
        URL postUrl = new URL(util.getValue("url_colv"));
// 打开连接
        HttpURLConnection connection = (HttpURLConnection) postUrl.openConnection();
        connection.setDoOutput(true);
        connection.setDoInput(true);
        connection.setRequestMethod("POST");
        connection.setUseCaches(false);
        connection.setInstanceFollowRedirects(true);
// 进行编码
        connection.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
        connection.connect();
        DataOutputStream out = new DataOutputStream(connection.getOutputStream());
        String content ="rest_data={\"session\":\""+colv_session+"\",\"outletNo\":\""+outletNo+"\",\"shipmentCode\":\""+shipmentCode+"\"}&method=getFSVsalesInfoFromCOLV&input_type=JSON&response_type=JSON";
        out.writeBytes(content);
        out.flush();
        out.close(); // flush and close
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(),"utf-8"));//设置编码,否则中文乱码
        String line=null;
        String key="";
        GetFSVsalesInfoFromCOLVVO getFSVsalesInfoFromCOLVVO=new GetFSVsalesInfoFromCOLVVO();
        while ((line = reader.readLine()) != null){
//line = new String(line.getBytes(), "utf-8");
            JSONObject resultJson= JSON.parseObject(line);
            if("202".equals(resultJson.getString("status"))){
                getFSVsalesInfoFromCOLVVO.setStatus(202);
                getFSVsalesInfoFromCOLVVO.setMessage("未获取到数据");
            }else if("200".equals(resultJson.getString("status"))){
                if("[]".equals(resultJson.getString("articleList"))){
                    getFSVsalesInfoFromCOLVVO.setStatus(202);
                    getFSVsalesInfoFromCOLVVO.setMessage("未获取到数据");
                }else{
                    getFSVsalesInfoFromCOLVVO.setStatus(200);
                    JSONArray jsonArray = resultJson.getJSONArray("articleList");
                    for(int i=0;i<jsonArray.size();i++){
                        ArticleListVO articleListVO=new ArticleListVO();
                        JSONObject object = JSON.parseObject(jsonArray.getString(i));
                        articleListVO.setArticleNo(object.getString("articleNo"));
                        articleListVO.setSalesCount(object.getInteger("salesCount"));
                        getFSVsalesInfoFromCOLVVO.getArticleList().add(articleListVO);
                    }
                }
            }else{
                return null;
            }
        }
        reader.close();
        connection.disconnect();
        return getFSVsalesInfoFromCOLVVO;
    }

    public GetunCashInfoFromCSVO getunCashInfoFromCS(String shipmentCode,String outletNo, HttpSession session) {
        DriverPhoneVO driverPhoneVO= (DriverPhoneVO) session.getAttribute("driverPhoneVO");
        String token=driverPhoneVO.getToken();

        GetunCashInfoFromCS getunCashInfoFromCS=new GetunCashInfoFromCS();
        HttpClient httpClient = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost(util.getValue("url_cs")+"getunCashInfoFromCS");
        getunCashInfoFromCS.setToken(token);
        getunCashInfoFromCS.setShipmentcode(shipmentCode);
        getunCashInfoFromCS.setOutletNo(outletNo);
        StringEntity entity = new StringEntity(JSON.toJSONString(getunCashInfoFromCS),"utf-8");
        httpPost.setHeader("Content-Type","application/json");
        httpPost.setEntity(entity);

        GetunCashInfoFromCSVO getunCashInfoFromCSVO = new GetunCashInfoFromCSVO();
        //httpPost.setHeader("x-access-token","");
        try {
            HttpResponse response = httpClient.execute(httpPost);
            String result= EntityUtils.toString(response.getEntity(),"utf-8");
            JSONObject resultJson= JSON.parseObject(result);
            if("202".equals(resultJson.getString("status"))){
                getunCashInfoFromCSVO.setStatus(202);
                getunCashInfoFromCSVO.setMessage("未获取到数据");
            }else if("200".equals(resultJson.getString("status"))){
                getunCashInfoFromCSVO.setStatus(200);
                JSONArray jsonArray = resultJson.getJSONArray("optList");
                for(int i=0;i<jsonArray.size();i++){
                    OptListVO optListVO=new OptListVO();
                    JSONObject object = JSON.parseObject(jsonArray.getString(i));
                    optListVO.setPlat(object.getString("plat"));
                    optListVO.setAmount(object.getDouble("amount"));
                    optListVO.setRelAmount(object.getDouble("relAmount"));
                    optListVO.setTermNo(object.getString("termNo"));
                    optListVO.setDeliverCycle(object.getString("deliverCycle"));
                    optListVO.setUpdateReason(object.getString("updateReason"));
                    optListVO.setCount(object.getInteger("count"));
                    getunCashInfoFromCSVO.getOptList().add(optListVO);
                }
            }else{
                return null;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return getunCashInfoFromCSVO;
    }

    public SubmitrefillDataToCSVO submitrefillDataToCs(String shipmentCode, String outletNo, int machineNum, double fsvDeposit,
                                                       int refillType, String articleList, String periodId, String payList,
                                                       String deliverDate, String lastDeliverDate, String photoList,HttpSession session) {
        DriverPhoneVO driverPhoneVO= (DriverPhoneVO) session.getAttribute("driverPhoneVO");
        String token=driverPhoneVO.getToken();
        String by=driverPhoneVO.getDriverName();

        SubmitrefillDataToCs submitrefillDataToCs=new SubmitrefillDataToCs();
        HttpClient httpClient = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost(util.getValue("url_cs")+"submitrefillDataToCs");
        submitrefillDataToCs.setToken(token);
        submitrefillDataToCs.setShipmentCode(shipmentCode);
        submitrefillDataToCs.setOutletNo(outletNo);
        submitrefillDataToCs.setMachineNum(machineNum);
        submitrefillDataToCs.setFsvDeposit(fsvDeposit);
        submitrefillDataToCs.setRefillType(refillType);
        submitrefillDataToCs.setPeriodId(periodId);
        submitrefillDataToCs.setDeliverDate(deliverDate);
        submitrefillDataToCs.setLastDeliverDate(lastDeliverDate);
        submitrefillDataToCs.setCreateDate(util.getTime());
        submitrefillDataToCs.setCreateBy(by);
        submitrefillDataToCs.setUpdateDate(util.getTime());
        submitrefillDataToCs.setUpdateBy(by);

        JSONArray jsonArray=JSON.parseArray(articleList);
        for(int i=0;i<jsonArray.size();i++){
            JSONObject jsonObject=jsonArray.getJSONObject(i);
            ArticleListToCS articleListToCS = new ArticleListToCS();
            articleListToCS.setArticleNo(jsonObject.getString("articleNo"));
//            if(jsonObject.getString("articleName")==null)
//                articleListToCS.setArticleName("不明");
//            else
//                articleListToCS.setArticleName(jsonObject.getString("articleName"));
            if(jsonObject.getInteger("salesNum")==null)
                articleListToCS.setSalesNum(0);
            else
                articleListToCS.setSalesNum(jsonObject.getInteger("salesNum"));
            articleListToCS.setReaSalesNum(jsonObject.getInteger("reaSalesNum"));
            articleListToCS.setRefillNum(jsonObject.getInteger("refillNum"));
            articleListToCS.setReturnNum(jsonObject.getInteger("returnNum"));
            submitrefillDataToCs.getArticleList().add(articleListToCS);
        }
        JSONArray jsonArray1=JSON.parseArray(payList);
        for(int i=0;i<jsonArray1.size();i++){
            JSONObject jsonObject=jsonArray1.getJSONObject(i);
            PayListToCS payListToCS = new PayListToCS();
            payListToCS.setTypeName(jsonObject.getString("plat"));
            payListToCS.setTermNo(jsonObject.getString("termNo"));
            payListToCS.setAmount(jsonObject.getDouble("amount"));
            payListToCS.setNum(jsonObject.getInteger("num"));
            if(jsonObject.getDouble("colvAmount")==null)
                payListToCS.setColvAmount(0);
            else
                payListToCS.setColvAmount(jsonObject.getDouble("colvAmount"));
            payListToCS.setUpdateReason(jsonObject.getString("updateReason"));
            submitrefillDataToCs.getPayList().add(payListToCS);
        }
        JSONArray jsonArray2=JSON.parseArray(photoList);
        for(int i=0;i<jsonArray2.size();i++){
            JSONObject jsonObject=jsonArray2.getJSONObject(i);
            PhotoListToCS photoListToCS = new PhotoListToCS();
            photoListToCS.setPhotoId(jsonObject.getString("photoId"));
            photoListToCS.setPhotoName(jsonObject.getString("photoName"));
            photoListToCS.setPhotoDt(jsonObject.getString("photoDt"));
            photoListToCS.setPhotoBy(jsonObject.getString("photoBy"));
            photoListToCS.setPhotoUrl(jsonObject.getString("photoUrl"));
            submitrefillDataToCs.getPhotoList().add(photoListToCS);
        }
        String s=JSON.toJSONString(submitrefillDataToCs);
        StringEntity entity = new StringEntity(JSON.toJSONString(submitrefillDataToCs),"utf-8");
        httpPost.setHeader("Content-Type","application/json");
        httpPost.setEntity(entity);

        SubmitrefillDataToCSVO submitrefillDataToCSVO = new SubmitrefillDataToCSVO();
        //httpPost.setHeader("x-access-token","");
        try {
            HttpResponse response = httpClient.execute(httpPost);
            String result= EntityUtils.toString(response.getEntity(),"utf-8");
            JSONObject resultJson= JSON.parseObject(result);
            if("202".equals(resultJson.getString("status"))){
                submitrefillDataToCSVO.setStatus(202);
                submitrefillDataToCSVO.setMessage("未获取到数据");
            }else if("500".equals(resultJson.getString("status"))){
                submitrefillDataToCSVO.setStatus(500);
                submitrefillDataToCSVO.setResult(resultJson.getInteger("result"));
                submitrefillDataToCSVO.setMessage(resultJson.getString("message"));
            }else if("200".equals(resultJson.getString("status"))){
                submitrefillDataToCSVO.setStatus(200);
                submitrefillDataToCSVO.setResult(resultJson.getInteger("result"));
                submitrefillDataToCSVO.setMessage(resultJson.getString("message"));
            }else{
                return null;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return submitrefillDataToCSVO;
    }
}
