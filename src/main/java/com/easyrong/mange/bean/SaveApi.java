/*
 * 文件名称:          SaveLog.java
 * 版权所有@ 2014-2016 上海信隆行信息科技股份有限公司，保留所有权利
 * 编译器:           JDK1.7
 * 时间:             下午5:06:42
 */

package com.easyrong.mange.bean;

import com.easyrong.mange.common.SaveRunnable;
import com.easyrong.mange.entity.Api;
import com.easyrong.mange.utils.ERThreadPool;

/**
 * TODO: 文件注释
 * <p>
 * <p>
 * Version:        V2.0
 * <p>
 * 作者:           ljj
 * <p>
 * 日期:           2016年6月17日
 * <p>
 * 负责人:         ljj
 * <p>
 * <p>
 */
public class SaveApi
{
    private static final String URI = "internal/saveApi";
    //
    private static final SaveApi instance = new SaveApi();

    /**
     * 
     * @return
     */
    public static SaveApi instance()
    {
        return instance;
    }

    /**
     * 
     * @param config
     * @param user
     * @param ip
     * @param type
     * @param description
     */
    public void saveApi(Configuration config, String name, String description)
    {
        ERThreadPool.instance().executeFixedThreadPool(
            new SaveRunnable(new Api(config.getAppName(), name,  description), config.getURL(URI),  null));
    }
   
}
