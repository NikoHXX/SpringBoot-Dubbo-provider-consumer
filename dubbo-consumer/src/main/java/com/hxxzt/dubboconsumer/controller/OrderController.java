package com.hxxzt.dubboconsumer.controller;

import com.hxxzt.publicinterface.bean.UserAddress;
import com.hxxzt.publicinterface.service.IOrderDubboConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class OrderController {

    @Autowired
    private IOrderDubboConsumerService orderDubboConsumerService;

    @RequestMapping("/init")
    @ResponseBody
    public List<UserAddress> init(@RequestParam("userId") Integer userId) {

        return orderDubboConsumerService.initOrder(userId);
    }
}