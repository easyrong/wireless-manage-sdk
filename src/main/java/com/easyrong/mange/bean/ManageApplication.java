/*
 * 文件名称:          ManageApplication.java
 * 版权所有@ 2014-2016 上海信隆行信息科技股份有限公司，保留所有权利
 * 编译器:           JDK1.7
 * 时间:             下午8:00:45
 */

package com.easyrong.mange.bean;

/**
 *  Bean, 向外提供API接口
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
public class ManageApplication
{
    /**
     * 
     */
    public ManageApplication()
    {
        config = new Configuration();
        config.setEnv(EnvironmentType.DEV);
    }

    /**
     * 
     * @param env
     */
    public void EnvironmentType(EnvironmentType env)
    {
        config.setEnv(env);
    }

    /**
     * 向SDK注册App，如果要使用应用管理后台，必须应用管理后台管理员申请App名称
     * 
     * @return true 成攻
     *               false 失败（原因：风络不通、没有申请App名称）
     */
    public boolean registryApp(String appName)
    {
        return RegistryApp.instance().registry(config, appName);
    }

    /**
     * 保存Log
     * @return
     */
    public void saveLog(String user, String ip, LogType type, String description)
    {
        if (config.isValid())
        {
            SaveLog.instance().saveLog(config, user, ip, type.getValue(), description);
        }
    }
    
    /**
     * 保存配置
     * @return
     */
    public void saveConfig(String name, String value)
    {
        if (config.isValid())
        {
            SaveConfig.instance().saveConfig(config, name, value);
        }
    }
    
    /**
     * 保存Log
     * @return
     */
    public void saveApi(String apiName, String description)
    {
        if (config.isValid())
        {
            SaveApi.instance().saveApi(config, apiName, description);
        }
    }
    
    /**
     * 保存Log
     * @return
     */
    public void saveApiAccess(String apiName)
    {
        if (config.isValid())
        {
            SaveApiAccess.instance().saveApiAccess(config, apiName);
        }
    }
    
    /**
     * 获取重定向URL，已经包括"redirect:"
     * @return
     */
    public String getRedirectURL()
    {
        return "redirect:" + config.getEnv().getHostURL()  + "?isRedirect=1?appName=" + config.getAppName(); 
    }
    
    private Configuration config;
}
