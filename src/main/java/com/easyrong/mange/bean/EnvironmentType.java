/*
 * 文件名称:          EnvironmentType.java
 * 版权所有@ 2014-2016 上海信隆行信息科技股份有限公司，保留所有权利
 * 编译器:           JDK1.7
 * 时间:             下午8:12:18
 */
package com.easyrong.mange.bean;

/**
 * TODO: 文件注释
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
public enum EnvironmentType
{
    // 开发环境 
    DEV
    {
        public String getHostURL()
        {
            //return "http://manage.easyrong.dev:8080/";
            return "http://127.0.0.1:8080/";
        }
    },
    // 测试环境
    TEST
    {
        public String getHostURL()
        {
            return "http://127.0.0.1:8080/";
        }
    },
    // 生产环境
    COM
    {
        public String getHostURL()
        {
            return "http://127.0.0.1:8080/";
        }
    };
    
    public abstract String  getHostURL();
}
