/*
 * 文件名称:          Config.java
 * 版权所有@ 2014-2016 上海信隆行信息科技股份有限公司，保留所有权利
 * 编译器:           JDK1.7
 * 时间:             下午8:53:30
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
public class Config
{
    //
    private String appName;
    //
    private String name;
    //
    private String value;
    
    public Config(String appName, String name, String value)
    {
        this.appName = appName;
        this.name = name;
        this.value = value;
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
     * @return Returns the name.
     */
    public String getName()
    {
        return name;
    }
    /**
     * @param name The name to set.
     */
    public void setName(String name)
    {
        this.name = name;
    }
    /**
     * @return Returns the value.
     */
    public String getValue()
    {
        return value;
    }
    /**
     * @param value The value to set.
     */
    public void setValue(String value)
    {
        this.value = value;
    }
}
