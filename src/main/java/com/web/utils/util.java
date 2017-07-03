package com.web.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.qiniu.util.Auth;
import com.qiniu.util.StringMap;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

/**
 * Created by jiangmq1 on 2016/12/26.
 */
public class util {
    /**
     * 获得当前时间
     */
    public static String getTime() {
        Date date = new Date();
        DateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
        String time = format.format(date);
        return time;
    }
    public static String getTimeForType() {
        Date date = new Date();
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String time = format.format(date);
        return time;
    }
    /**
     * 获得当前时间+1
     */
    public static String getMoreTime() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, +1);    //得到后一天
        String year = String.valueOf(calendar.get(Calendar.YEAR));
        String month = String.valueOf(calendar.get(Calendar.MONTH) + 1);
        if(Integer.parseInt(month)<10){
            month="0"+month;
        }
        String day = String.valueOf(calendar.get(Calendar.DATE));
        if(Integer.parseInt(day)<10){
            day="0"+day;
        }
        String time = "" + year + month + day;
        return time;
    }


    public static String getValue(String key){
        Properties properties = new Properties();
        String path = Thread.currentThread().getContextClassLoader().getResource("parameter.properties").getPath();
        try {
            properties.load(new FileInputStream(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String value=properties.getProperty(key);
        return value;
    }

    //获取colv的session值
    public static String getCOLVSessionId() throws IOException {
        URL postUrl = new URL(getValue("url_colv"));
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
        String content = "rest_data={\"user_auth\":{\"user_name\":\"CS-API\",\"password\":\"6d6a784f371c78b483ef843de3290ba2\",\"version\":\"1\"},\"application_name\":\"RestTest\",\"name_value_list\":[]}&method=login&input_type=JSON&response_type=JSON";

        out.writeBytes(content);
        out.flush();
        out.close(); // flush and close
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(),"utf-8"));//设置编码,否则中文乱码
        String line="";
        String key="";
        while ((line = reader.readLine()) != null){
//line = new String(line.getBytes(), "utf-8");
            JSONObject resultJson= JSON.parseObject(line);
            key=resultJson.getString("id");

        }
        reader.close();
        connection.disconnect();
        return key;
    }

    /**
     * 获取七牛的upToken
     * @param bucketName
     * @return
     */
    public static String getQiNiuToken(String bucketName){
        long _dataline = System.currentTimeMillis() / 1000 + 24*3600;
        String accessKey = "mGlP-O1TlF8IxoixWeUQdEiXKi5tP_fj_hGml20Y";
        String secretKey = "jucfM3Yu_W-HXLuP87Ecnh4HgCzMSzxOYHcJOzr_";
        String bucket = bucketName;
        Auth auth = Auth.create(accessKey, secretKey);
        StringMap putPolicy = new StringMap();
        putPolicy.put("deadline",_dataline);
        long expireSeconds = 3600;

        String upToken = auth.uploadToken(bucket,null,expireSeconds,putPolicy);
        return upToken;
    }

}
