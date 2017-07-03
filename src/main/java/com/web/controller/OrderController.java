package com.web.controller;

import com.web.model.order.SubmitOrderList;
import com.web.service.OrderService;
import com.web.vo.order.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by jiangmq1 on 2017/5/16.
 */
@Controller
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    /**
     * api-818
     * @param session
     * @return
     */
    @RequestMapping("/getUnbillingOrderHeaderList")
    @ResponseBody
    public OrderHeaderListVO getUnbillingOrderHeaderList(HttpSession session){
        OrderHeaderListVO orderHeaderListVO=orderService.getUnbillingOrderHeaderList(session);
        if(orderHeaderListVO==null){
            orderHeaderListVO=new OrderHeaderListVO();
            orderHeaderListVO.setStatus(400);
            orderHeaderListVO.setMessage("请求失败，请重试");
        }
        return orderHeaderListVO;
    }

    /**
     * api-007
     * @param TranCodeSrc
     * @param session
     * @return
     */
    @RequestMapping("/getDriverMessage")
    @ResponseBody
    public GetDriverMessageVO getDriverMessage(String TranCodeSrc, HttpSession session){
        GetDriverMessageVO getDriverMessageVO=orderService.getDriverMessage(TranCodeSrc,session);
        if(getDriverMessageVO==null){
            getDriverMessageVO=new GetDriverMessageVO();
            getDriverMessageVO.setStatus(400);
            getDriverMessageVO.setMessage("请求失败，请重试");
        }
        return getDriverMessageVO;
    }

    /**
     * api-044
     * @param session
     * @return
     */
    @RequestMapping("/getAllProducts")
    @ResponseBody
    public GetAllProductsVO getAllProducts(HttpSession session){
        GetAllProductsVO getAllProductsVO=orderService.getAllProducts(session);
        if(getAllProductsVO==null){
            getAllProductsVO=new GetAllProductsVO();
            getAllProductsVO.setStatus(400);
            getAllProductsVO.setMessage("请求失败，请重试");
        }
        return getAllProductsVO;
    }

    /**
     * api-821
     * @param foTranCode
     * @param session
     * @return
     */
    @RequestMapping("/getUnbillingOrderDetail")
    @ResponseBody
    public OrderItemsVO getUnbillingOrderDetail(String foTranCode, HttpSession session){
        OrderItemsVO orderItemsVO=orderService.getUnbillingOrderDetail(foTranCode,session);
        if(orderItemsVO==null){
            orderItemsVO=new OrderItemsVO();
            orderItemsVO.setStatus(400);
            orderItemsVO.setMessage("请求失败，请重试");
        }
        return orderItemsVO;
    }

    /**
     * api-815
     * @param tranCodeSRC
     * @param orderItemList
     * @param session
     * @return
     */
    @RequestMapping("/submitOrder")
    @ResponseBody
    public SubmitOrderVO submitOrder(String tranCodeSRC, String orderItemList, HttpSession session){
        SubmitOrderVO submitOrderVO=orderService.submitOrder(tranCodeSRC,orderItemList,session);
        if(submitOrderVO==null){
            submitOrderVO=new SubmitOrderVO();
            submitOrderVO.setStatus(400);
            submitOrderVO.setMessage("请求失败，请重试");
        }
        return submitOrderVO;
    }

    /**
     * api-001
     * @param session
     * @return
     */
    @RequestMapping("/getFSVProducts")
    @ResponseBody
    public GetFSVProductsVO getFSVProducts(HttpSession session){
        GetFSVProductsVO getFSVProductsVO=orderService.getFSVProducts(session);
        if(getFSVProductsVO==null){
            getFSVProductsVO=new GetFSVProductsVO();
            getFSVProductsVO.setStatus(400);
            getFSVProductsVO.setMessage("请求失败，请重试");
        }
        return getFSVProductsVO;
    }
}
