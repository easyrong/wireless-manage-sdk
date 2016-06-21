/*
 * 文件名称:          HttpCallBack.java
 * 版权所有@ 2014-2016 上海信隆行信息科技股份有限公司，保留所有权利
 * 编译器:           JDK1.7
 * 时间:             上午8:55:22
 */
package com.easyrong.mange.http;

import com.alibaba.fastjson.JSONObject;

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
public interface HttpCallBack
{
    /**
     * HTTP连接错误回调
     * @param status
     * @param code
     * @param message
     */
    public void onError(int status, int code, String message);
    
    /**
     * Http正确返回调用
     * @param json
     */
    public void onSuccess(JSONObject json);
    
}
