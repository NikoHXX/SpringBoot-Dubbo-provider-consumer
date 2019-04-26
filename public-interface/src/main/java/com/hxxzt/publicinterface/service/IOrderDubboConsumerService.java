package com.hxxzt.publicinterface.service;

import com.hxxzt.publicinterface.bean.UserAddress;

import java.util.List;

public interface IOrderDubboConsumerService {

    /**
     * 根据用户Id初始化订单
     *
     * @param userId
     */
    public List<UserAddress> initOrder(Integer userId);
}