package com.web.controller;

import com.web.service.LoginService;
import com.web.utils.util;
import com.web.vo.login.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by jiangmq1 on 2017/5/15.
 */
@Controller
@RequestMapping("/employee")
public class LoginController {
    @Autowired
    private LoginService loginService;

    @RequestMapping("/login")
    @ResponseBody
    public DriverPhoneVO employeeLogin(String mobileNo,String password,String openId, HttpSession session) {
        DriverPhoneVO driverPhoneVO=loginService.loginWithDriverPhone(mobileNo,password,openId);
        if(driverPhoneVO==null){
            driverPhoneVO=new DriverPhoneVO();
            driverPhoneVO.setStatus(400);
            driverPhoneVO.setMessageText("获取失败");
        }
        String key= null;
        try {
            key = util.getCOLVSessionId();
        } catch (IOException e) {
            session.setAttribute("colv_session",key);
            session.setAttribute("driverPhoneVO",driverPhoneVO);
            session.setMaxInactiveInterval(-1);
            return driverPhoneVO;
        }

        Map<String, String> user=new HashMap<String, String>();
        user.put("mobileNo",mobileNo);
        user.put("password",password);
        user.put("openId",openId);
        session.setAttribute("user",user);

        session.setAttribute("colv_session",key);
        session.setAttribute("driverPhoneVO",driverPhoneVO);
        session.setMaxInactiveInterval(-1);
        return driverPhoneVO;
    }

    @RequestMapping("/validateMobile")
    @ResponseBody
    public ValidateMobileNoVO validateMobile(String mobileNo){
        ValidateMobileNoVO validateMobileNoVO=loginService.validateMobile(mobileNo);
        if(validateMobileNoVO==null){
            validateMobileNoVO=new ValidateMobileNoVO();
            validateMobileNoVO.setStatus(400);
            validateMobileNoVO.setMessageText("请输入正确的手机号");
        }
        return validateMobileNoVO;
    }


    @RequestMapping("/checkSession")
    @ResponseBody
    public String checkSession(HttpServletRequest request , HttpServletResponse response,HttpSession session){

        Map<String,String> user= (Map<String, String>)session.getAttribute("user");
        if(null !=user) {
            return "200" ;
        }
        return "400" ;
    }



    //清除登录的session
    @RequestMapping("/cleanSession")
    @ResponseBody
    public String cleanCookie(HttpServletRequest request , HttpServletResponse response, HttpSession session){

        request.getSession().removeAttribute("user");

        return  "200";
    }



    @RequestMapping("/getValidateCode")
    @ResponseBody
    public GetValidateCodeVO getValidateCode(String mobileNo, int sendTag){
        GetValidateCodeVO getValidateCodeVO=loginService.getValidateCode(mobileNo,sendTag);
        if(getValidateCodeVO==null){
            getValidateCodeVO=new GetValidateCodeVO();
            getValidateCodeVO.setStatus(400);
            getValidateCodeVO.setMessageText("请输入正确的手机号");
        }
        return getValidateCodeVO;
    }

    @RequestMapping("/resetPasswordByValidateCode")
    @ResponseBody
    public ResetPasswordVO resetPasswordByValidateCode(String mobileNo, String validateCode,String newPassword,String confrimNewPassword){
        ResetPasswordVO resetPasswordVO=loginService.resetPasswordByValidateCode(mobileNo,validateCode,newPassword,confrimNewPassword);
        if(resetPasswordVO==null){
            resetPasswordVO=new ResetPasswordVO();
            resetPasswordVO.setStatus(400);
            resetPasswordVO.setMessageText("重置失败");
        }
        return resetPasswordVO;
    }
    @RequestMapping("/getUpToken")
    @ResponseBody
    public QiniuVO getUpToken(){
        String bucketName=util.getValue("bucket_name");
        String upToken=util.getQiNiuToken(bucketName);
        QiniuVO qiniuVO = new QiniuVO();
        qiniuVO.setUpToken(upToken);
        qiniuVO.setUrl(util.getValue("qiniu_url"));
        return qiniuVO;
    }
}
