package com.web.vo.scheduling;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jiangmq1 on 2017/5/23.
 */
public class DeviceListVO {
    private String groupCode;
    private String modelCode;
    private String assetCode;
    private String status;
    private String articleNo;
    private String installDate;
    private String assetNum;
    private String articleSize;
    private int deposit;
    private String depositType;
    private String refrigerantIndicator;
    private int numOfDoor;
    private String deviceSubCategoryCode;
    private String olvFlag;
    private List<BomListVO> BOMList=new ArrayList<BomListVO>();

    public String getGroupCode() {
        return groupCode;
    }

    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode;
    }

    public String getModelCode() {
        return modelCode;
    }

    public void setModelCode(String modelCode) {
        this.modelCode = modelCode;
    }

    public String getAssetCode() {
        return assetCode;
    }

    public void setAssetCode(String assetCode) {
        this.assetCode = assetCode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getArticleNo() {
        return articleNo;
    }

    public void setArticleNo(String articleNo) {
        this.articleNo = articleNo;
    }

    public String getInstallDate() {
        return installDate;
    }

    public void setInstallDate(String installDate) {
        this.installDate = installDate;
    }

    public String getAssetNum() {
        return assetNum;
    }

    public void setAssetNum(String assetNum) {
        this.assetNum = assetNum;
    }

    public String getArticleSize() {
        return articleSize;
    }

    public void setArticleSize(String articleSize) {
        this.articleSize = articleSize;
    }

    public int getDeposit() {
        return deposit;
    }

    public void setDeposit(int deposit) {
        this.deposit = deposit;
    }

    public String getDepositType() {
        return depositType;
    }

    public void setDepositType(String depositType) {
        this.depositType = depositType;
    }

    public String getRefrigerantIndicator() {
        return refrigerantIndicator;
    }

    public void setRefrigerantIndicator(String refrigerantIndicator) {
        this.refrigerantIndicator = refrigerantIndicator;
    }

    public int getNumOfDoor() {
        return numOfDoor;
    }

    public void setNumOfDoor(int numOfDoor) {
        this.numOfDoor = numOfDoor;
    }

    public String getDeviceSubCategoryCode() {
        return deviceSubCategoryCode;
    }

    public void setDeviceSubCategoryCode(String deviceSubCategoryCode) {
        this.deviceSubCategoryCode = deviceSubCategoryCode;
    }

    public String getOlvFlag() {
        return olvFlag;
    }

    public void setOlvFlag(String olvFlag) {
        this.olvFlag = olvFlag;
    }

    public List<BomListVO> getBOMList() {
        return BOMList;
    }

    public void setBOMList(List<BomListVO> BOMList) {
        this.BOMList = BOMList;
    }
}
