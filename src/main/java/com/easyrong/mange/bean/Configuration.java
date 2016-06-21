/*
 * 文件名称:          Configuration.java
 * 版权所有@ 2014-2016 上海信隆行信息科技股份有限公司，保留所有权利
 * 编译器:           JDK1.7
 * 时间:             下午8:04:08
 */
package com.easyrong.mange.bean;

/**
 * 需要采用后台基本配置
 * <p>
 * <p>
 * Version:        V2.0
 * <p>
 * 作者:           ljj
 * <p>
 * 日期:           2016年6月15日
 * <p>
 * 负责人:         ljj
 * <p>
 * <p>
 */
public class Configuration
{
    
    /**
     * @return Returns the appName.
     */
    protected String getAppName()
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
     * @return Returns the evn.
     */
    protected EnvironmentType getEnv()
    {
        return env;
    }
    /**
     * @return Returns the appID.
     */
    public String getAppId()
    {
        return appId;
    }
    /**
     * @param appID The appID to set.
     */
    public void setAppId(String appId)
    {
        this.appId = appId;
    }
    /**
     * @param evn The evn to set.
     */
    protected void setEnv(EnvironmentType env)
    {
        this.env = env;
    }
    
    /**
     * 
     * @param uri
     * @return
     */
    public String getURL(String uri)
    {
       return env.getHostURL() + uri;
    }
    
    /**
     *  判断配置是否有效 
     * @return
     */
    protected boolean isValid()
    {
        return !(getAppName() == null || getAppName().length() == 0);
    }
    

    // 应用名称
    private String appName;
    //
    private String appId;
    // 运行环境
    private EnvironmentType env;
}
