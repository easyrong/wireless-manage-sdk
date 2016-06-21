/*
 * 文件名称:          LogType.java
 * 版权所有@ 2014-2016 上海信隆行信息科技股份有限公司，保留所有权利
 * 编译器:           JDK1.7
 * 时间:             下午5:00:43
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
 * 日期:           2016年6月17日
 * <p>
 * 负责人:         ljj
 * <p>
 * <p>
 */
public enum LogType
{
    // 访问类
    VISIT 
    {
        public int getValue()
        {
            return 1;
        }
    },
    // 任务因
    TASK
    {
        public int getValue()
        {
            return 2;
        }
    },
    DEVICE
    {
        public int getValue()
        {
            return 3;
        }
    },
    WARN
    {
        public int getValue()
        {
            return 4;
        }
    },
    OTHER
    {
        public int getValue()
        {
            return 5;
        }
    };
    
    public abstract int getValue();
}
