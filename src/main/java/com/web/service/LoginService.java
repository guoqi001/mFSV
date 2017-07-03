package com.web.service;

import com.web.vo.login.DriverPhoneVO;
import com.web.vo.login.GetValidateCodeVO;
import com.web.vo.login.ResetPasswordVO;
import com.web.vo.login.ValidateMobileNoVO;

import java.io.IOException;

/**
 * Created by jiangmq1 on 2017/5/15.
 */
public interface LoginService {
    DriverPhoneVO loginWithDriverPhone(String mobileNo, String password, String openId);
    ValidateMobileNoVO validateMobile(String mobileNo);
    GetValidateCodeVO getValidateCode(String mobileNo, int sendTag);
    ResetPasswordVO resetPasswordByValidateCode(String mobileNo, String validateCode, String newPassword, String confrimNewPassword);
}
