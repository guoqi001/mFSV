package com.web.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.web.model.login.DriverPhone;
import com.web.model.login.GetValidateCode;
import com.web.model.login.ResetPassword;
import com.web.model.login.ValidateMobileNo;
import com.web.service.LoginService;
import com.web.utils.util;
import com.web.vo.login.DriverPhoneVO;
import com.web.vo.login.GetValidateCodeVO;
import com.web.vo.login.ResetPasswordVO;
import com.web.vo.login.ValidateMobileNoVO;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * Created by jiangmq1 on 2017/5/15.
 */
@Service("LoginService")
public class LoginServiceImpl implements LoginService{

    public DriverPhoneVO loginWithDriverPhone(String mobileNo, String password, String openId){
        DriverPhone driverPhone=new DriverPhone();
        HttpClient httpClient = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost(util.getValue("url_cs")+"loginWithDriverPhone");
        driverPhone.setMobileNo(mobileNo);
        driverPhone.setPassword(password);
        driverPhone.setOpenId(openId);
        StringEntity entity = new StringEntity(JSON.toJSONString(driverPhone),"utf-8");
        httpPost.setHeader("Content-Type","application/json");
        httpPost.setEntity(entity);

        DriverPhoneVO driverPhoneVO = new DriverPhoneVO();
        //httpPost.setHeader("x-access-token","");
        try {
            HttpResponse response = httpClient.execute(httpPost);
            String result= EntityUtils.toString(response.getEntity(),"utf-8");
            JSONObject resultJson= JSON.parseObject(result);

            if("500".equals(resultJson.getString("status"))){
                driverPhoneVO.setStatus(resultJson.getInteger("status"));
                driverPhoneVO.setMessageText(resultJson.getString("messageText"));
            }else if("200".equals(resultJson.getString("status"))){
                //员工Token
                driverPhoneVO.setStatus(resultJson.getInteger("status"));
                driverPhoneVO.setMessageText(resultJson.getString("messageText"));
                driverPhoneVO.setDriverName(resultJson.getString("driverName"));
                driverPhoneVO.setDriverNo(resultJson.getString("driverNo"));
                driverPhoneVO.setToken(resultJson.getString("token"));
                driverPhoneVO.setTokenStatus(resultJson.getString("tokenStatus"));
            }else{
                return  null;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return driverPhoneVO;
    }

    public ValidateMobileNoVO validateMobile(String mobileNo) {
        if("".equals(mobileNo)){
            return null;
        }
        ValidateMobileNo validateMobileNo=new ValidateMobileNo();
        HttpClient httpClient = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost(util.getValue("url_cs")+"validateMobileNo");
        validateMobileNo.setMobileNo(mobileNo);
        StringEntity entity = new StringEntity(JSON.toJSONString(validateMobileNo),"utf-8");
        httpPost.setHeader("Content-Type","application/json");
        httpPost.setEntity(entity);

        ValidateMobileNoVO validateMobileNoVO = new ValidateMobileNoVO();
        //httpPost.setHeader("x-access-token","");
        try {
            HttpResponse response = httpClient.execute(httpPost);
            String result= EntityUtils.toString(response.getEntity(),"utf-8");
            JSONObject resultJson= JSON.parseObject(result);

            if("500".equals(resultJson.getString("status"))){
                validateMobileNoVO.setStatus(resultJson.getInteger("status"));
                validateMobileNoVO.setMessageText(resultJson.getString("messageText"));
            }else if("200".equals(resultJson.getString("status"))){
                validateMobileNoVO.setStatus(resultJson.getInteger("status"));
                validateMobileNoVO.setMessageText(resultJson.getString("messageText"));
            }else{
                return  null;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return validateMobileNoVO;
    }

    public GetValidateCodeVO getValidateCode(String mobileNo, int sendTag) {
        if("".equals(mobileNo)){
            return null;
        }
        GetValidateCode getValidateCode=new GetValidateCode();
        HttpClient httpClient = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost(util.getValue("url_cs")+"getValidateCode");
        getValidateCode.setMobileNo(mobileNo);
        getValidateCode.setSendTag(sendTag);
        StringEntity entity = new StringEntity(JSON.toJSONString(getValidateCode),"utf-8");
        httpPost.setHeader("Content-Type","application/json");
        httpPost.setEntity(entity);

        GetValidateCodeVO getValidateCodeVO = new GetValidateCodeVO();
        //httpPost.setHeader("x-access-token","");
        try {
            HttpResponse response = httpClient.execute(httpPost);
            String result= EntityUtils.toString(response.getEntity(),"utf-8");
            JSONObject resultJson= JSON.parseObject(result);

            if("500".equals(resultJson.getString("status"))){
                getValidateCodeVO.setStatus(resultJson.getInteger("status"));
                getValidateCodeVO.setMessageText(resultJson.getString("messageText"));
            }else if("200".equals(resultJson.getString("status"))){
                getValidateCodeVO.setStatus(resultJson.getInteger("status"));
                getValidateCodeVO.setMessageText(resultJson.getString("messageText"));
            }else{
                return  null;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return getValidateCodeVO;
    }

    public ResetPasswordVO resetPasswordByValidateCode(String mobileNo, String validateCode, String newPassword, String confrimNewPassword) {
        ResetPassword resetPassword=new ResetPassword();
        HttpClient httpClient = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost(util.getValue("url_cs")+"resetPasswordByValidateCode");
        resetPassword.setMobileNo(mobileNo);
        resetPassword.setValidateCode(validateCode);
        resetPassword.setNewPassword(newPassword);
        resetPassword.setConfrimNewPassword(confrimNewPassword);
        StringEntity entity = new StringEntity(JSON.toJSONString(resetPassword),"utf-8");
        httpPost.setHeader("Content-Type","application/json");
        httpPost.setEntity(entity);

        ResetPasswordVO resetPasswordVO = new ResetPasswordVO();
        //httpPost.setHeader("x-access-token","");
        try {
            HttpResponse response = httpClient.execute(httpPost);
            String result= EntityUtils.toString(response.getEntity(),"utf-8");
            JSONObject resultJson= JSON.parseObject(result);

            if("500".equals(resultJson.getString("status"))){
                resetPasswordVO.setStatus(resultJson.getInteger("status"));
                resetPasswordVO.setMessageText(resultJson.getString("messageText"));
            }else if("200".equals(resultJson.getString("status"))){
                resetPasswordVO.setStatus(resultJson.getInteger("status"));
                resetPasswordVO.setMessageText(resultJson.getString("messageText"));
            }else{
                return  null;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return resetPasswordVO;
    }
}
