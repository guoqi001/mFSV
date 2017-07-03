package com.web.controller;

import com.web.service.InventoryService;
import com.web.vo.inventory.ArticleListVO;
import com.web.vo.inventory.GetTruckInventoryVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * Created by jiangmq1 on 2017/5/25.
 */
@Controller
@RequestMapping("/inventory")
public class InventoryController {
    @Autowired
    private InventoryService inventoryService;

    @RequestMapping("/getTruckInventory")
    @ResponseBody
    public GetTruckInventoryVO getTruckInventory(HttpSession session){
        GetTruckInventoryVO getTruckInventoryVO=inventoryService.getTruckInventory(session);
        if(getTruckInventoryVO==null){
            getTruckInventoryVO=new GetTruckInventoryVO();
            getTruckInventoryVO.setStatus(400);
            getTruckInventoryVO.setMessage("请求失败，请重试");
        }
        return getTruckInventoryVO;
    }
}
