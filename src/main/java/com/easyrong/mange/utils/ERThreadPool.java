/*
 * 文件名称:          ThreadPool.java
 * 版权所有@ 2014-2016 上海信隆行信息科技股份有限公司，保留所有权利
 * 编译器:           JDK1.7
 * 时间:             下午5:31:26
 */
package com.easyrong.mange.utils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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
public class ERThreadPool
{
     
    private static final ERThreadPool instance = new ERThreadPool();
    
    /**
     * 
     * @return
     */
    public static ERThreadPool instance()
    {
        return instance;
    }
    /**
     * 
     * @param command
     */
    public void executeCachedThreadPool(Runnable command)
    {
        cachedExecutorService.execute(command);
    }
    
    /**
     * 
     */
    public void executeFixedThreadPool(Runnable command)
    {
        fixedTExecutorService.execute(command);
    }
    
    /**
     * 
     */
    public void destroy()
    {
        //
        cachedExecutorService.shutdown();
        //
        fixedTExecutorService.shutdown();
    }
    
    // 缓存线程池
    private ExecutorService cachedExecutorService = Executors.newCachedThreadPool();
    // 固定大小线程池，请尽量使用这个线程
    private ExecutorService fixedTExecutorService = Executors.newFixedThreadPool(500);
}
