/*
 * 文件名称:          SaveLog.java
 * 版权所有@ 2014-2016 上海信隆行信息科技股份有限公司，保留所有权利
 * 编译器:           JDK1.7
 * 时间:             下午5:06:42
 */

package com.easyrong.mange.bean;

import com.easyrong.mange.common.SaveRunnable;
import com.easyrong.mange.entity.Log;
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
public class SaveLog
{
    private static final String URI = "internal/saveLog";
    //
    private static final SaveLog instance = new SaveLog();

    /**
     * 
     * @return
     */
    public static SaveLog instance()
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
    public void saveLog(Configuration config, String user, String ip, int type, String description)
    {
        ERThreadPool.instance().executeFixedThreadPool(
            new SaveRunnable(new Log(config.getAppName(), user, ip, type, description), config.getURL(URI) , null));
    }
}
