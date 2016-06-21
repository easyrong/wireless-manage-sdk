/*
 * 文件名称:          RegistryApp.java
 * 版权所有@ 2014-2016 上海信隆行信息科技股份有限公司，保留所有权利
 * 编译器:           JDK1.7
 * 时间:             上午10:03:57
 */
package com.easyrong.mange.bean;

import java.util.HashMap;
import java.util.Map;

import org.apache.http.entity.StringEntity;

import com.alibaba.fastjson.JSONObject;
import com.easyrong.mange.http.HttpCallBack;
import com.easyrong.mange.http.HttpClientKit;
import com.easyrong.mange.utils.JSONConst;

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
public class RegistryApp
{
    ThreadLocal<Boolean> threadLocal = new ThreadLocal<Boolean>();
    // 
    private static final String URI = "internal/registryApp";
    //
    private static final RegistryApp instance = new RegistryApp();
    //
    protected static RegistryApp instance()
    {
        return instance;
    }
    
    /**
     * 
     */
    protected boolean registry(final Configuration config, String appName)
    {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("appName", appName);
        StringEntity se = new StringEntity(JSONObject.toJSONString(map), "UTF-8");
        HttpClientKit.instance().doPost(config.getEnv().getHostURL() + URI, se, null, true, new HttpCallBack()
        {
            
            public void onSuccess(JSONObject json)
            {
                System.out.println(json);
                JSONObject app = json.getJSONArray(JSONConst.KEY_RESULT).getJSONObject(0);
                config.setAppId(app.getString("appId"));
                config.setAppName(app.getString("name"));
                threadLocal.set(true);
            }
            
            public void onError(int status, int code, String message)
            {
                System.out.println(message);
                threadLocal.set(false);
            }
        });
        return  threadLocal.get();
    }

}
