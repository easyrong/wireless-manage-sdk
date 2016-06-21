/*
 * 文件名称:          Log.java
 * 版权所有@ 2014-2016 上海信隆行信息科技股份有限公司，保留所有权利
 * 编译器:           JDK1.7
 * 时间:             下午7:12:50
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
public class Log
{
    // 应用名称
    private String appName;
    // 用户名
    private String user;
    // IP
    private String ip;
    // 类型
    private int type;
    // 描述
    private String description;

    /**
     * 
     * @param appName
     * @param user
     * @param ip
     * @param type
     * @param description
     */
    public Log(String appName, String user, final String ip, int type, final String description)
    {
            this.appName = appName;
            this.user = user;
            this.ip = ip;
            this.type = type;
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
     * @return Returns the user.
     */
    public String getUser()
    {
        return user;
    }

    /**
     * @param user The user to set.
     */
    public void setUser(String user)
    {
        this.user = user;
    }

    /**
     * @return Returns the ip.
     */
    public String getIp()
    {
        return ip;
    }

    /**
     * @param ip The ip to set.
     */
    public void setIp(String ip)
    {
        this.ip = ip;
    }

    /**
     * @return Returns the type.
     */
    public int getType()
    {
        return type;
    }

    /**
     * @param type The type to set.
     */
    public void setType(int type)
    {
        this.type = type;
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
