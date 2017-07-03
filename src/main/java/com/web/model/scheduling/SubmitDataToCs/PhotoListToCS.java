package com.web.model.scheduling.SubmitDataToCs;

import com.alibaba.fastjson.annotation.JSONType;

/**
 * Created by jiangmq1 on 2017/5/25.
 */
@JSONType(orders = {"photoId","photoName","photoDt","photoBy","photoUrl"})
public class PhotoListToCS {
    private String photoId="";
    private String photoName="";
    private String photoDt="";
    private String photoBy="";
    private String photoUrl="";

    public String getPhotoId() {
        return photoId;
    }

    public void setPhotoId(String photoId) {
        this.photoId = photoId;
    }

    public String getPhotoName() {
        return photoName;
    }

    public void setPhotoName(String photoName) {
        this.photoName = photoName;
    }

    public String getPhotoDt() {
        return photoDt;
    }

    public void setPhotoDt(String photoDt) {
        this.photoDt = photoDt;
    }

    public String getPhotoBy() {
        return photoBy;
    }

    public void setPhotoBy(String photoBy) {
        this.photoBy = photoBy;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }
}
