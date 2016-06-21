/*
 * 文件名称:          AllTests.java
 * 版权所有@ 2014-2016 上海信隆行信息科技股份有限公司，保留所有权利
 * 编译器:           JDK1.7
 * 时间:             下午7:41:10
 */
package com.easyrong.mange;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

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
@ RunWith(Suite.class)
@ SuiteClasses({RegistryAppTest.class, SaveLogTest.class, SaveApiTest.class, SaveApiAccessTest.class, SaveConfigTest.class})
public class ManageSDKTests
{
    @Before
    public void setUp()
    {
        Thread.currentThread().setDaemon(true);
    }
}
