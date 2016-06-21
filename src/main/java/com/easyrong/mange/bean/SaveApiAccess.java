/*
 * 文件名称:          SaveLog.java
 * 版权所有@ 2014-2016 上海信隆行信息科技股份有限公司，保留所有权利
 * 编译器:           JDK1.7
 * 时间:             下午5:06:42
 */

package com.easyrong.mange.bean;

import com.easyrong.mange.common.SaveRunnable;
import com.easyrong.mange.entity.ApiAccess;
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
public class SaveApiAccess
{
    private static final String URI = "internal/saveApiAccess";
    //
    private static final SaveApiAccess instance = new SaveApiAccess();

    /**
     * 
     * @return
     */
    public static SaveApiAccess instance()
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
    public void saveApiAccess(Configuration config, String apiName)
    {
        ERThreadPool.instance().executeFixedThreadPool(
            new SaveRunnable(new ApiAccess(config.getAppName(), apiName), config.getURL(URI),  null));
    }
   
}
