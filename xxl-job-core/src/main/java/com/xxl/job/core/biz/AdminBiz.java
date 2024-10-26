package com.xxl.job.core.biz;

import com.xxl.job.core.biz.model.HandleCallbackParam;
import com.xxl.job.core.biz.model.RegistryParam;
import com.xxl.job.core.biz.model.ReturnT;

import java.util.List;

/**
 * @author xuxueli 2017-07-27 21:52:49
 */
public interface AdminBiz {


    // ---------------------- callback ----------------------

    /**
     * 回调接口
     *
     * @param callbackParamList
     * @return
     */
    public ReturnT<String> callback(List<HandleCallbackParam> callbackParamList);


    // ---------------------- registry ----------------------

    /**
     * 注册执行器
     *
     * @param registryParam
     * @return
     */
    ReturnT<String> registry(RegistryParam registryParam);

    /**
     * 下线（取消注册）
     *
     * @param registryParam
     * @return
     */
    ReturnT<String> registryRemove(RegistryParam registryParam);

}
