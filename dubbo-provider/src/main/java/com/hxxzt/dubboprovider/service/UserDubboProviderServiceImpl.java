package com.hxxzt.dubboprovider.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.hxxzt.publicinterface.bean.UserAddress;
import com.hxxzt.publicinterface.service.IUserDubboProviderService;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

//注册为 Dubbo 服务(暴露服务)
@Service(version = "1.0.0")
@Component
public class UserDubboProviderServiceImpl implements IUserDubboProviderService {


    @Override
    public List<UserAddress> getUserAddressList(Integer userId) {
        UserAddress address1 = new UserAddress(1, "北京市朝阳区管庄", 1, "niko", "13252082226", "Y");
        UserAddress address2 = new UserAddress(2, "北京市海淀区中关村", 1, "niko", "13252082226", "N");
        return Arrays.asList(address1, address2);
    }

}