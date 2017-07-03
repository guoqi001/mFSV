package com.web.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.web.service.SchedulingService;
import com.web.vo.scheduling.*;
import com.web.vo.scheduling.CustomerArticles.GetCustomerArticlesVO;
import com.web.vo.scheduling.CustomerProfile.GetCustomerProfileVO;
import com.web.vo.scheduling.FSVsalesInfoFromCOLV.GetFSVsalesInfoFromCOLVVO;
import com.web.vo.scheduling.FSVsalesInfoFromCS.GetFSVsalesInfoFromCSVO;
import com.web.vo.scheduling.UnCashInfoFromCOLV.GetunCashInfoFromCOLVVO;
import com.web.vo.scheduling.UnCashInfoFromCS.GetunCashInfoFromCSVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created by jiangmq1 on 2017/5/22.
 */
@Controller
@RequestMapping("/scheduling")
public class SchedulingController {
    @Autowired
    private SchedulingService schedulingService;

    /**
     * api-003
     * @param session
     * @return
     */
    @RequestMapping("/getShipmentList")
    @ResponseBody
    public GetShipmentListVO getShipmentList(HttpSession session){
        GetShipmentListVO getShipmentListVO=schedulingService.getShipmentList(session);
        if(getShipmentListVO==null){
            getShipmentListVO=new GetShipmentListVO();
            getShipmentListVO.setStatus(400);
            getShipmentListVO.setMessageText("请求失败，请重试");
        }
        return getShipmentListVO;
    }

    /**
     * api-008
     * @param shipmentCode
     * @param csConfirm
     * @param session
     * @return
     */
    @RequestMapping("/CSConfirm")
    @ResponseBody
    public ConfirmVO CSConfirm(String shipmentCode, Integer csConfirm, HttpSession session){
//        shipmentCode="00234563006";
//        csConfirm=1;
        ConfirmVO confirmVO=schedulingService.CSConfirm(shipmentCode,csConfirm,session);
        if(confirmVO==null){
            confirmVO=new ConfirmVO();
            confirmVO.setStatus(400);
            confirmVO.setMessageText("请求失败，请重试");
        }
        return confirmVO;
    }

    /**
     * api-002
     * @param shipmentCode
     * @param session
     * @return
     */
    @RequestMapping("/getDriverOutlet")
    @ResponseBody
    public GetDriverOutletVO getDriverOutlet(String shipmentCode, HttpSession session){
//        shipmentCode="00234563006";
        GetDriverOutletVO getDriverOutletVO=schedulingService.getDriverOutlet(shipmentCode,session);
        if(getDriverOutletVO==null){
            getDriverOutletVO=new GetDriverOutletVO();
            getDriverOutletVO.setStatus(400);
            getDriverOutletVO.setMessage("请求失败，请重试");
        }
        return getDriverOutletVO;
    }

    /**
     * api-927
     * @param outletNo
     * @param session
     * @return
     */
    @RequestMapping("/getCustomerDeviceList")
    @ResponseBody
    public String getCustomerDeviceList(String outletNo,HttpSession session){
//        outletNo="0510073607";
        String getCustomerDeviceList=schedulingService.getCustomerDeviceList(outletNo,session);
        if(getCustomerDeviceList==null){
            GetCustomerDeviceListVO getCustomerDeviceListVO=new GetCustomerDeviceListVO();
            getCustomerDeviceListVO.setStatus(400);
            getCustomerDeviceListVO.setMessage("请求失败，请重试");
            Object array =  JSONArray.toJSON(getCustomerDeviceListVO);
            getCustomerDeviceList= array.toString();
        }
        return getCustomerDeviceList;
    }

    /**
     * api-004
     * @param outletNo
     * @param session
     * @return
     * @throws IOException
     */
    @RequestMapping("/getMachineStatus")
    @ResponseBody
    public GetMachineStatusVO getMachineStatus(String outletNo,HttpSession session) throws IOException {
//        outletNo="0510045299";
        GetMachineStatusVO getMachineStatusVO=schedulingService.getMachineStatus(outletNo,session);
        if(getMachineStatusVO==null){
            getMachineStatusVO=new GetMachineStatusVO();
            getMachineStatusVO.setStatus(400);
            getMachineStatusVO.setMessage("请求失败，请重试");
        }
        return getMachineStatusVO;
    }

    /**
     * api-800
     * @param outletNo
     * @param session
     * @return
     */
    @RequestMapping("/getCustomerProfile")
    @ResponseBody
    public String getCustomerProfile(String outletNo, HttpSession session){
//        outletNo="0510000121";
        String getCustomerProfile=schedulingService.getCustomerProfile(outletNo,session);
        if(getCustomerProfile==null){
            GetCustomerProfileVO getCustomerProfileVO=new GetCustomerProfileVO();
            getCustomerProfileVO.setStatus(400);
            getCustomerProfileVO.setMessage("请求失败，请重试");
            Object array =  JSONArray.toJSON(getCustomerProfileVO);
            getCustomerProfile= array.toString();
        }
        return getCustomerProfile;
    }

    /**
     * api-012
     * @param shipmentCode
     * @param outletNo
     * @param session
     * @return
     * @throws IOException
     */
    @RequestMapping("/getunCashInfoFromCOLV")
    @ResponseBody
    public String getunCashInfoFromCOLV( String shipmentCode,String outletNo,HttpSession session) throws IOException{
//        shipmentCode="0015002685";
//        outletNo="0510000867";
        String getunCashInfoFromCOLV=schedulingService.getunCashInfoFromCOLV(shipmentCode,outletNo,session);
        if(getunCashInfoFromCOLV==null){
            GetunCashInfoFromCOLVVO getunCashInfoFromCOLVVO=new GetunCashInfoFromCOLVVO();
            getunCashInfoFromCOLVVO.setStatus(400);
            getunCashInfoFromCOLVVO.setMessage("请求失败，请重试");
            Object array =  JSONArray.toJSON(getunCashInfoFromCOLVVO);
            getunCashInfoFromCOLV= array.toString();
        }
        return getunCashInfoFromCOLV;
    }

    /**
     * api-013
     * @param shipmentCode
      * @param outletNo
     * @param session
     * @return
     */
    @RequestMapping("/getFSVsalesInfoFromCS")
    @ResponseBody
    public String getFSVsalesInfoFromCS( String shipmentCode,String outletNo,HttpSession session){
//        shipmentCode="0016940674";
//        outletNo="0510073607";
        String getFSVsalesInfoFromCS=schedulingService.getFSVsalesInfoFromCS(shipmentCode,outletNo,session);
        if(getFSVsalesInfoFromCS==null){
            GetFSVsalesInfoFromCSVO getFSVsalesInfoFromCSVO=new GetFSVsalesInfoFromCSVO();
            getFSVsalesInfoFromCSVO.setStatus(400);
            getFSVsalesInfoFromCSVO.setMessage("请求失败，请重试");
            Object array =  JSONArray.toJSON(getFSVsalesInfoFromCSVO);
            getFSVsalesInfoFromCS= array.toString();
        }
        return getFSVsalesInfoFromCS;
    }

    /**
     * api-827
     * @param outletNo
     * @param session
     * @return
     */
    @RequestMapping("/getCustomerArticles")
    @ResponseBody
    public GetCustomerArticlesVO getCustomerArticles (String outletNo,HttpSession session){
//        outletNo="0510072745";
        GetCustomerArticlesVO getCustomerArticlesVO=schedulingService.getCustomerArticles(outletNo,session);
        if(getCustomerArticlesVO==null){
            getCustomerArticlesVO=new GetCustomerArticlesVO();
            getCustomerArticlesVO.setStatus(400);
            getCustomerArticlesVO.setMessage("请求失败，请重试");
        }
        return getCustomerArticlesVO;
    }

    /**
     * api-011
     * @param shipmentCode
     * @param outletNo
     * @param session
     * @return
     * @throws IOException
     */
    @RequestMapping("/getFSVsalesInfoFromCOLV")
    @ResponseBody
    public GetFSVsalesInfoFromCOLVVO getFSVsalesInfoFromCOLV(String shipmentCode,String outletNo, HttpSession session) throws IOException {
//        shipmentCode="0015002685";
//        outletNo="0510000867";
        GetFSVsalesInfoFromCOLVVO getFSVsalesInfoFromCOLVVO=schedulingService.getFSVsalesInfoFromCOLV(shipmentCode,outletNo,session);
        if(getFSVsalesInfoFromCOLVVO==null){
            getFSVsalesInfoFromCOLVVO=new GetFSVsalesInfoFromCOLVVO();
            getFSVsalesInfoFromCOLVVO.setStatus(400);
            getFSVsalesInfoFromCOLVVO.setMessage("请求失败，请重试");
        }
        return getFSVsalesInfoFromCOLVVO;
    }

    /**
     * api-014
     * @param shipmentCode
     * @param outletNo
     * @param session
     * @return
     */
    @RequestMapping("/getunCashInfoFromCS")
    @ResponseBody
    public GetunCashInfoFromCSVO getunCashInfoFromCS(String shipmentCode,String outletNo, HttpSession session){
//        shipmentCode="00234563006";
//        outletNo="0510000121";
        GetunCashInfoFromCSVO getunCashInfoFromCSVO=schedulingService.getunCashInfoFromCS(shipmentCode,outletNo,session);
        if(getunCashInfoFromCSVO==null){
            getunCashInfoFromCSVO=new GetunCashInfoFromCSVO();
            getunCashInfoFromCSVO.setStatus(400);
            getunCashInfoFromCSVO.setMessage("请求失败，请重试");
        }
        return getunCashInfoFromCSVO;
    }

    /**
     * api-006
     * @param shipmentCode
     * @param outletNo
     * @param machineNum
     * @param fsvDeposit
     * @param refillType
     * @param articleList
     * @param periodId
     * @param payList
     * @param deliverDate
     * @param lastDeliverDate
     * @param photoList
     * @param session
     * @return
     */
    @RequestMapping("/submitrefillDataToCs")
    @ResponseBody
    public SubmitrefillDataToCSVO submitrefillDataToCs(String shipmentCode, String outletNo, int machineNum,
        double fsvDeposit, int refillType, String articleList,String periodId,String payList,String deliverDate,
        String lastDeliverDate,String photoList,HttpSession session){

        SubmitrefillDataToCSVO submitrefillDataToCSVO=schedulingService.submitrefillDataToCs(shipmentCode,outletNo,machineNum,fsvDeposit,
                refillType,articleList,periodId,payList,deliverDate,lastDeliverDate,photoList,session);

        if(submitrefillDataToCSVO==null){
            submitrefillDataToCSVO=new SubmitrefillDataToCSVO();
            submitrefillDataToCSVO.setStatus(400);
            submitrefillDataToCSVO.setMessage("请求失败，请重试");
        }
        return submitrefillDataToCSVO;
    }
}
