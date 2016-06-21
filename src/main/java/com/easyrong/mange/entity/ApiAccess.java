/*
 * 文件名称:          ApiAccess.java
 * 版权所有@ 2014-2016 上海信隆行信息科技股份有限公司，保留所有权利
 * 编译器:           JDK1.7
 * 时间:             下午8:57:45
 */
package com.easyrong.mange.entity;

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
public class ApiAccess
{
    private String appName;
    //
    private String apiName;
    
    /**
     * 
     * @param appName
     * @param apiName
     */
    public ApiAccess(String appName, String apiName)
    {
        this.appName = appName;
        this.apiName = apiName;
    }
    
    /**
     * @return Returns the appName.
     */
    public String getAppName()
    {
        return appName;
    }
    /**
     * @param appName The appName to set.
     */
    public void setAppName(String appName)
    {
        this.appName = appName;
    }
    /**
     * @return Returns the apiName.
     */
    public String getApiName()
    {
        return apiName;
    }
    /**
     * @param apiName The apiName to set.
     */
    public void setApiName(String apiName)
    {
        this.apiName = apiName;
    }
}
