/*
 * 文件名称:          ERLoggerManage.java
 * 版权所有@ 2014-2016 上海信隆行信息科技股份有限公司，保留所有权利
 * 编译器:           JDK1.8
 * 时间:             上午9:16:54
 */
package com.easyrong.mange.common;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 日志管理
 * <p>
 * <p>
 * Version:        V2.0
 * <p>
 * 作者:           liangjinjing
 * <p>
 * 日期:           2016年6月10日
 * <p>
 * 负责人:         liangjinjing
 * <p>
 * <p>
 */
public class ERLoggerManage
{

    private Map<String, Logger> mapLogger = new ConcurrentHashMap<String, Logger>();
    
    private static final ERLoggerManage instance = new ERLoggerManage();
    
    
    /**
     * 
     * @param clz
     * @return
     */
    private Logger getLogger(Class<? extends Object> clz)
    {
        Logger logger = mapLogger.get(clz.getName());
        if (logger == null)
        {
            logger = LoggerFactory.getLogger(clz);
            mapLogger.put(clz.getName(), logger);
        }
        return logger;
    }


    /**
     * 
     * @param msg
     */
    public static void debug(Class<? extends Object> clz, String msg)
    {
        
        instance.getLogger(clz).debug(msg);
    }


    /**
     * 
     * @param msg
     * @param t
     */
    public static void debug(Class<? extends Object> clz, String msg, Throwable t)
    {
        instance.getLogger(clz).debug(msg, t);
        
    }

    /**
     * 
     * @param clz
     * @param msg
     */
    public static void info(Class<? extends Object> clz, String msg)
    {
        instance.getLogger(clz).info(msg);
        
    }

    /**
     * 
     * @param msg
     * @param t
     */
    public static void info(Class<? extends Object> clz, String msg, Throwable t)
    {
        instance.getLogger(clz).info(msg, t);
    }

    /**
     * 
     * @param msg
     */
    public static void warn(Class<? extends Object> clz, String msg)
    {
        instance.getLogger(clz).warn(msg);
    }

    /**
     * 
     * @param clz
     * @param msg
     * @param t
     */
    public static void warn(Class<? extends Object> clz, String msg, Throwable t)
    {
        instance.getLogger(clz).warn(msg, t);
    }

    /**
     * 
     * @param clz
     * @param msg
     */
    public void error(Class<? extends Object> clz, String msg)
    {
        instance.getLogger(clz).error(msg);
    }

    /**
     * 
     * @param clz
     * @param msg
     * @param t
     */
    public void error(Class<? extends Object> clz, String msg, Throwable t)
    {
        instance.getLogger(clz).error(msg, t);
    }
}
