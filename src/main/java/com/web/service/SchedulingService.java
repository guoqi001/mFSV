package com.web.service;

import com.web.vo.scheduling.*;
import com.web.vo.scheduling.CustomerArticles.GetCustomerArticlesVO;
import com.web.vo.scheduling.CustomerProfile.GetCustomerProfileVO;
import com.web.vo.scheduling.FSVsalesInfoFromCOLV.GetFSVsalesInfoFromCOLVVO;
import com.web.vo.scheduling.UnCashInfoFromCS.GetunCashInfoFromCSVO;

import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by jiangmq1 on 2017/5/22.
 */
public interface SchedulingService {
    GetShipmentListVO getShipmentList(HttpSession session);
    ConfirmVO CSConfirm(String shipmentCode, Integer csConfirm, HttpSession session);

    GetDriverOutletVO getDriverOutlet(String shipmentCode, HttpSession session);

    String getCustomerDeviceList( String outletNo,HttpSession session);

    GetMachineStatusVO getMachineStatus(String outletNo,HttpSession session) throws IOException;

    String getCustomerProfile(String outletNo, HttpSession session);

    String getunCashInfoFromCOLV(String shipmentCode,String outletNo,HttpSession session) throws IOException;

    String getFSVsalesInfoFromCS(String shipmentCode,String outletNo, HttpSession session);

    GetCustomerArticlesVO getCustomerArticles(String outletNo,HttpSession session);

    GetFSVsalesInfoFromCOLVVO getFSVsalesInfoFromCOLV(String shipmentCode,String outletNo,HttpSession session) throws IOException;

    GetunCashInfoFromCSVO getunCashInfoFromCS(String shipmentCode, String outletNo,HttpSession session);

    SubmitrefillDataToCSVO submitrefillDataToCs(String shipmentCode, String outletNo, int machineNum, double fsvDeposit, int refillType, String articleList, String periodId, String payList, String deliverDate, String lastDeliverDate, String photoList, HttpSession session);
}
