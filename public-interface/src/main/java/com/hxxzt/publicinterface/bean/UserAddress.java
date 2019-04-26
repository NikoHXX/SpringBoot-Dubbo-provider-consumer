package com.hxxzt.publicinterface.bean;

import java.io.Serializable;

/**
 * 城市实体类
 */
public class UserAddress implements Serializable {
    private static final long serialVersionUID = -1L;

    private Integer id;

    /**
     * 收货地址
     */
    private String userAddress;

    /**
     * 用户ID
     */
    private Integer userId;

    /**
     * 收货人
     */
    private String consignee;


    /**
     * 手机号码
     */
    private String tel;

    /**
     * 是否为默认地址 Y-是,N-否
     */
    private String isDefault;

    public UserAddress() {
        super();
    }

    public UserAddress(Integer id, String userAddress, Integer userId, String consignee, String tel, String isDefault) {
        this.id = id;
        this.userAddress = userAddress;
        this.userId = userId;
        this.consignee = consignee;
        this.tel = tel;
        this.isDefault = isDefault;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getConsignee() {
        return consignee;
    }

    public void setConsignee(String consignee) {
        this.consignee = consignee;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(String isDefault) {
        this.isDefault = isDefault;
    }
}