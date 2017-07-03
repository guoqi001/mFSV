package com.web.service;

import com.web.model.order.SubmitOrderList;
import com.web.vo.order.*;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by jiangmq1 on 2017/5/16.
 */
public interface OrderService {
    OrderHeaderListVO getUnbillingOrderHeaderList(HttpSession session);
    GetDriverMessageVO getDriverMessage(String TranCodeSrc, HttpSession session);
    GetAllProductsVO getAllProducts(HttpSession session);
    OrderItemsVO getUnbillingOrderDetail(String foTranCode, HttpSession session);

    SubmitOrderVO submitOrder(String tranCodeSRC, String orderItemList, HttpSession session);

    GetFSVProductsVO getFSVProducts(HttpSession session);
}
