/*
 * 文件名称:          Api.java
 * 版权所有@ 2014-2016 上海信隆行信息科技股份有限公司，保留所有权利
 * 编译器:           JDK1.7
 * 时间:             下午8:55:53
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
public class Api
{
    //
    private String appName;
    //
    private String name;
    //
    private String description;
    
    /**
     * 
     * @param appName
     * @param name
     * @param description
     */
    public Api(String appName, String name,  String description)
    {
       this.appName = appName;
       this.name = name;
       this.description = description;
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
     * @return Returns the description.
     */
    public String getDescription()
    {
        return description;
    }
    /**
     * @param description The description to set.
     */
    public void setDescription(String description)
    {
        this.description = description;
    }
}
