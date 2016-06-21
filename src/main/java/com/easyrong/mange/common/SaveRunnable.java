/*
 * 文件名称:          SaveRunnable.java
 * 版权所有@ 2014-2016 上海信隆行信息科技股份有限公司，保留所有权利
 * 编译器:           JDK1.7
 * 时间:             下午9:08:32
 */
package com.easyrong.mange.common;

import org.apache.http.entity.StringEntity;

import com.alibaba.fastjson.JSONObject;
import com.easyrong.mange.http.HttpCallBack;
import com.easyrong.mange.http.HttpClientKit;
import com.easyrong.mange.utils.Kit;

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
public class SaveRunnable implements Runnable
{
    /**
     * 
     * @param saveObject
     * @param sdkConfig
     */
    public SaveRunnable(Object saveObject,  String url,  HttpCallBack callBack)
    {
        this.saveObject = saveObject;
        this.url = url;
        if (callBack != null)
        {
            this.callback = callBack;
        }
    }
    
    /**
     * 
     */
    public void run()
    {
        StringEntity se = new StringEntity(Kit.beanToJSONObject(saveObject).toJSONString(), "UTF-8");
        HttpClientKit.instance().doPost(url, se, null, false, callback);
    }
    
    //
    private HttpCallBack callback = new HttpCallBack()
    {
        public void onSuccess(JSONObject json)
        {
        }
        
        public void onError(int status, int code, String message)
        {
            
        }
    };
    //
    private String url;
    //
    private Object saveObject; 
}
