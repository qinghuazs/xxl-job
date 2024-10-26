package com.xxl.job.admin.core.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * 执行器分组信息
 */
public class XxlJobGroup {

    /**
     * 主键
     */
    private int id;
    /**
     * 应用名称
     */
    private String appname;
    /**
     * 执行器名称
     */
    private String title;
    /**
     * 注册方式，0=自动注册、1=手动录入
     * 执行器地址类型
     */
    private int addressType;
    /**
     * 执行器地址列表，多地址逗号分隔(手动录入)
     * 用于调度中心与执行器之间的通信
     */
    private String addressList;
    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 执行器地址列表(系统注册)
     */
    private List<String> registryList;

    /**
     * 获取执行器地址列表，解析addressList获取到registryList
     * @return
     */
    public List<String> getRegistryList() {
        if (addressList!=null && addressList.trim().length()>0) {
            registryList = new ArrayList<String>(Arrays.asList(addressList.split(",")));
        }
        return registryList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAppname() {
        return appname;
    }

    public void setAppname(String appname) {
        this.appname = appname;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getAddressType() {
        return addressType;
    }

    public void setAddressType(int addressType) {
        this.addressType = addressType;
    }

    public String getAddressList() {
        return addressList;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public void setAddressList(String addressList) {
        this.addressList = addressList;
    }

}
