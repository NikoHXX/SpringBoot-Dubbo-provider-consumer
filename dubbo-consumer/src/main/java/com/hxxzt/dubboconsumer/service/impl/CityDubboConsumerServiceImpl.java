package com.hxxzt.dubboconsumer.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.hxxzt.publicinterface.bean.UserAddress;
import com.hxxzt.publicinterface.service.IOrderDubboConsumerService;
import com.hxxzt.publicinterface.service.IUserDubboProviderService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityDubboConsumerServiceImpl implements IOrderDubboConsumerService {

    @Reference(version = "1.0.0")//dubbo远程引用service服务
    private IUserDubboProviderService userDubboProviderService;

    @Override
    public List<UserAddress> initOrder(Integer userId) {
        System.out.println("用户Id:" + userId);
        List<UserAddress> addressList = userDubboProviderService.getUserAddressList(userId);
        return addressList;
    }
}