package com.web.service;

import com.web.vo.inventory.GetTruckInventoryVO;

import javax.servlet.http.HttpSession;

/**
 * Created by jiangmq1 on 2017/5/25.
 */
public interface InventoryService {
    GetTruckInventoryVO getTruckInventory(HttpSession session);
}
