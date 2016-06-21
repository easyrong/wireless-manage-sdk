/*
 * 文件名称:          HttpClientUtil.java
 * 版权所有@ 2014-2016 上海信隆行信息科技股份有限公司，保留所有权利
 * 编译器:           JDK1.7
 * 时间:             下午1:40:48
 */

package com.easyrong.mange.http;

import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.concurrent.FutureCallback;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.nio.client.CloseableHttpAsyncClient;
import org.apache.http.impl.nio.client.HttpAsyncClients;
import org.apache.http.impl.nio.conn.PoolingNHttpClientConnectionManager;
import org.apache.http.impl.nio.reactor.DefaultConnectingIOReactor;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSONObject;
import com.easyrong.mange.common.ERLoggerManage;
import com.easyrong.mange.dictionary.ErrorMessage;
import com.easyrong.mange.dictionary.Status;
import com.easyrong.mange.utils.NullJudge;

/**
 * http通信工具类
 * <p>
 * <p>
 * Version:        V2.0
 * <p>
 * 作者:           yangyu
 * <p>
 * 日期:           2015年11月26日
 * <p>
 * 负责人:         liangjinjing
 * <p>
 * <p>
 */
public class HttpClientKit
{
    /**
     * 最大连接数
     */
    private static final int MAX_TOATLE = 200;
    /**
     * 超时时间
     */
    private static final int MAX_TIMEOUT = 5000;
    /**
     * 初始化
     */
    private static HttpClientKit instance = new HttpClientKit();
    /**
     * 连接池
     */
    private PoolingNHttpClientConnectionManager cmPool;
    /**
     * 同步 http client
     */
    private CloseableHttpAsyncClient asyncClient;
    /**
     * 通信配置
     */
    private RequestConfig requestConfig;

    /**
     * HttpClientUtil工具类实例获取
     * @return HttpClientUtil
     */
    public static HttpClientKit instance()
    {
        return instance;
    }

    /**
     * 初始化连接池、连接配置及客户端
     */
    private HttpClientKit()
    {
        try
        {
            // 初始化连接池
            cmPool = new PoolingNHttpClientConnectionManager(new DefaultConnectingIOReactor());
            // 最大连接数
            cmPool.setMaxTotal(MAX_TOATLE);
            // 读取超时、连接超时、从连接池获取连接实例的超时、在提交请求之前 测试连接是否可用
            requestConfig = RequestConfig.custom().setSocketTimeout(MAX_TIMEOUT)
                .setConnectTimeout(MAX_TIMEOUT).setConnectionRequestTimeout(MAX_TIMEOUT)
                .setStaleConnectionCheckEnabled(true).build();
            // 生成客户端
            asyncClient = HttpAsyncClients.custom().setConnectionManager(cmPool)
                .setDefaultRequestConfig(requestConfig).build();
            // 定时清楚过期和闲置连接  定时方式：无延迟、每2秒执行一次
            Executors.newSingleThreadScheduledExecutor()
                .scheduleAtFixedRate(new IdleConnectionMonitor(cmPool), 0, 2, TimeUnit.SECONDS);
        }
        catch(Exception e)
        {
            ERLoggerManage.info(this.getClass(), e.getMessage(), e);
        }
    }

    /**
     * 同步Post请求
     * @param url 请求地址
     * @param httpEntity 数据包
     * @param header http头部
     * @param isSync  = true 同步， = false 异步
     * @return String 返回数据
     */
    public void doPost(String url, HttpEntity httpEntity, Map<String, String> header,  boolean isSync, HttpCallBack callBack)
    {
        // url非空校验
        if (NullJudge.instance().judgeString(url))
        {
            return ;
        }
        // 创建请求
        HttpPost httpPost = new HttpPost(url);
        // 如果StringEntity, 则需要设置content
        if (httpEntity instanceof StringEntity)
        {
                // 设置ContentType
            ((StringEntity)httpEntity).setContentEncoding("UTF-8");
            ((StringEntity)httpEntity).setContentType("application/json");
        }
        // 设定数据
        httpPost.setEntity(httpEntity);
        // 
        if (isSync)
        {
             executeSync(httpPost, header, callBack) ;
        }
        else
        {
             executeAsync(httpPost, header, callBack);
        }
    }

    /**
     * 同步Get请求
     * @param url 请求地址
     * @return String 返回数据
     */
    public void doGet(String url, Map<String, String> header, HttpCallBack callBack)
    {
        // url非空校验
        if (NullJudge.instance().judgeString(url))
        {
            return;
        }
        // 创建请求
        executeSync(new HttpGet(url), header, callBack);
    }

    /**
     * 设置StringEntity
     * @param str 请求参数(json字符串)
     * @return StringEntity
     */
    public StringEntity setStringEntity(String str)
    {
        StringEntity s = new StringEntity(str, "UTF-8");
        // 设置ContentType
        s.setContentEncoding("UTF-8");
        s.setContentType("application/json");
        return s;
    }

    /**
     * 异步请求
     * @param httpmethod 请求方法
     * @return String 返回数据
     */
    private void executeAsync(final HttpRequestBase method, Map<String, String> header,
        final HttpCallBack callBack)
    {
        // 设定头部
        if (header != null)
        {
            for (Map.Entry<String, String> entry : header.entrySet())
            {
                method.setHeader(entry.getKey(), entry.getValue());
            }
        }
        // 启动连接池
        asyncClient.start();

        // 提交请求，同步请求回调参数无需设置
        Future<HttpResponse> feutre = asyncClient.execute(method, new FutureCallback<HttpResponse>()
        {
            //
            int status = 0;
            int code = ErrorMessage.ERR_IN_SYSTEM.getValue();
            String message = ErrorMessage.ERR_IN_SYSTEM.getName();

            /**
             *
             */
            public void failed(Exception ex)
            {
                code = ErrorMessage.ERR_IN_REQUEST.getValue();
                message = ErrorMessage.ERR_IN_REQUEST.getName();
                callBack.onError(status, code, message);
                //
                ERLoggerManage.info(this.getClass(),
                    method.getURI() + ", code=" + code + ", message=" + message, ex);
            }

            /**
             * 
             * @param result
             */
            public void completed(HttpResponse result)
            {
                try
                {
                    JSONObject json = JSONObject
                        .parseObject(EntityUtils.toString(result.getEntity(), "UTF-8"));
                    int sta = json.getIntValue("status");
                    if (sta == Status.FAIL.getValue())
                    {
                        status = sta;
                        code = json.getIntValue("code");
                        message = json.getString("message");
                        callBack.onError(status, code, message);
                        //
                        ERLoggerManage.info(this.getClass(),
                            method.getURI() + ", code=" + code + ", message=" + message);
                    }
                    else
                    {
                        callBack.onSuccess(json);
                    }
                }
                catch(Exception e)
                {
                    status = Status.FAIL.getValue();
                    code = ErrorMessage.ERR_IN_DATA.getValue();
                    message = ErrorMessage.ERR_IN_DATA.getName();
                    callBack.onError(status, code, message);
                    //
                    ERLoggerManage.info(this.getClass(),
                        method.getURI() + ", code=" + code + ", message=" + message, e);
                }
            }

            /**
             */
            public void cancelled()
            {
                status = Status.FAIL.getValue();
                code = ErrorMessage.ERR_IN_REQUEST_CALCEL.getValue();
                message = ErrorMessage.ERR_IN_REQUEST_CALCEL.getName();
                callBack.onError(status, code, message);
                // 
                ERLoggerManage.info(this.getClass(),
                    method.getURI() + ", code=" + code + ", message=" + message);
            }
        });

        try
        {
            System.out.println(feutre.get().getEntity().toString());
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    /**
     * 异步请求
     * @param httpmethod 请求方法
     * @return String 返回数据
     */
    private void executeSync(final HttpRequestBase method, Map<String, String> header,  final HttpCallBack callBack)
    {
        // 设定头部
        if (header != null)
        {
            for (Map.Entry<String, String> entry : header.entrySet())
            {
                method.setHeader(entry.getKey(), entry.getValue());
            }
        }
        // 启动连接池
        asyncClient.start();
        //
        int status = 0;
        int code = ErrorMessage.ERR_IN_SYSTEM.getValue();
        String message = ErrorMessage.ERR_IN_SYSTEM.getName();
        // 提交请求，同步请求回调参数无需设置
        Future<HttpResponse> result =  asyncClient.execute(method, null);
        try
        {
            HttpResponse resp = result.get();
            // 请求失败
            if (resp.getStatusLine().getStatusCode() != HttpStatus.SC_OK
                && resp.getStatusLine().getStatusCode() != HttpStatus.SC_INTERNAL_SERVER_ERROR)
            {
                code = ErrorMessage.ERR_IN_REQUEST.getValue();
                message = ErrorMessage.ERR_IN_REQUEST.getName();
                callBack.onError(status, code, message);
                //
                ERLoggerManage.info(this.getClass(), method.getURI() + ", code=" + code + ", message=" + message);
            }
            else
            {
                try
                {
                    JSONObject json = JSONObject.parseObject(EntityUtils.toString(resp.getEntity(), "UTF-8"));
                    int sta = json.getIntValue("status");
                    if (sta == Status.FAIL.getValue())
                    {
                        status = sta;
                        code = json.getIntValue("code");
                        message = json.getString("message");
                        callBack.onError(status, code, message);
                        //
                        ERLoggerManage.info(this.getClass(), method.getURI() + ", code=" + code + ", message=" + message);
                    }
                    else
                    {
                        callBack.onSuccess(json);
                    }
                }
                catch (Exception e)
                {
                    status = Status.FAIL.getValue();
                    code = ErrorMessage.ERR_IN_DATA.getValue();
                    message = ErrorMessage.ERR_IN_DATA.getName();
                    callBack.onError(status, code, message);
                    //
                    ERLoggerManage.info(this.getClass(), method.getURI() + ", code=" + code + ", message=" + message,  e);
                }
            }
        }
        catch (Exception e)
        {
            code = ErrorMessage.ERR_IN_REQUEST.getValue();
            message = ErrorMessage.ERR_IN_REQUEST.getName();
            callBack.onError(status, code, message);
            //
            ERLoggerManage.info(this.getClass(), method.getURI() + ", code=" + code + ", message=" + message);
        }
    }

    /**
     * 定时清楚过期和闲置连接
     */
    private final class IdleConnectionMonitor implements Runnable
    {
        PoolingNHttpClientConnectionManager connectionManager;

        public IdleConnectionMonitor(PoolingNHttpClientConnectionManager connectionManager)
        {
            this.connectionManager = connectionManager;
        }

        public void run()
        {
            // 关闭超过连接保持时间的空闲连接
            connectionManager.closeExpiredConnections();
            // 关闭一定时间空闲的连接  一定时间：10秒
            connectionManager.closeIdleConnections(10, TimeUnit.SECONDS);
        }
    }
}
