package com.hxxzt.publicinterface.service;


import com.hxxzt.publicinterface.bean.UserAddress;

import java.util.List;

public interface IUserDubboProviderService {
    /**
     * 根据用户Id查询所有的收货地址
     *
     * @param userId
     * @return
     */
    public List<UserAddress> getUserAddressList(Integer userId);
}