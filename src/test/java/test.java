import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.web.model.login.DriverPhone;
import com.web.model.login.ValidateMobileNo;
import com.web.utils.util;
import com.web.vo.login.DriverPhoneVO;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * Created by jiangmq1 on 2017/5/16.
 */
public class test {
    public static void main(String[] args) {
       DriverPhone driverPhone=new DriverPhone();
        HttpClient httpClient = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost(util.getValue("url_cs")+"loginWithDriverPhone");
        driverPhone.setMobileNo("18367197823");
        driverPhone.setPassword("Aa123456");
        driverPhone.setOpenId("123456789098765");
        String j=JSON.toJSONString(driverPhone);
        StringEntity entity = new StringEntity(JSON.toJSONString(driverPhone),"utf-8");
        httpPost.setHeader("Content-Type","application/json");
//        StringEntity entity = new StringEntity(JSON.toJSONString(driverPhone),"utf-8");
        httpPost.setEntity(entity);

        DriverPhoneVO driverPhoneVO = new DriverPhoneVO();
        //httpPost.setHeader("x-access-token","");
        try {
            HttpResponse response = httpClient.execute(httpPost);
            String result= EntityUtils.toString(response.getEntity(),"utf-8");
            JSONObject resultJson= JSON.parseObject(result);
            System.out.println(resultJson);
           System.out.println(resultJson.getString("token"));
            System.out.println(resultJson.getString("driverNo"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
