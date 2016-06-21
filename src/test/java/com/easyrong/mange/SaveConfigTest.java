/*
 * 文件名称:          SaveLogTest.java
 * 版权所有@ 2014-2016 上海信隆行信息科技股份有限公司，保留所有权利
 * 编译器:           JDK1.7
 * 时间:             下午7:34:10
 */
package com.easyrong.mange;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.easyrong.mange.bean.ManageApplication;

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
public class SaveConfigTest
{

    private ManageApplication app = new ManageApplication();
    @ Before
    public void setUp() throws Exception
    {
        app.registryApp("wechat");
        System.out.println(this.getClass());
    }

    @ After
    public void tearDown() throws Exception
    {
        Thread.sleep(10000);
    }

    @ Test
    public void test()
    {
        app.saveConfig("mange.url", "manage.easyrong.test:8080");
    }

}
