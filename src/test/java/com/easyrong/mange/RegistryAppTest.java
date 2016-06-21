/*
 * 文件名称:          RegistryAppTest.java
 * 版权所有@ 2014-2016 上海信隆行信息科技股份有限公司，保留所有权利
 * 编译器:           JDK1.7
 * 时间:             上午10:56:45
 */
package com.easyrong.mange;

import org.junit.After;
import org.junit.Assert;
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
public class RegistryAppTest
{

    @ Before
    public void setUp() throws Exception
    {
        System.out.println(this.getClass());
    }

    @ After
    public void tearDown() throws Exception
    {
    }

    @ Test
    public void testNameExist()
    {
        ManageApplication app = new ManageApplication();
        Assert.assertEquals(app.registryApp("wechat"),  true);
    }
    
    @ Test
    public void testNameNotExist()
    {
        //ManageApplication app = new ManageApplication();
        //Assert.assertEquals(app.registryApp("wechat11"),  false);
    }

}
