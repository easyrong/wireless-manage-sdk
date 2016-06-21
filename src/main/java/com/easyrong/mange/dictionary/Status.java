/*
 * 文件名称:          status.java
 * 版权所有@ 2014-2016 上海信隆行信息科技股份有限公司，保留所有权利
 * 编译器:           JDK1.7
 * 时间:             上午10:25:34
 */
package com.easyrong.mange.dictionary;

/**
 * 返回结果
 * <p>
 * <p>
 * Version:        V2.0
 * <p>
 * 作者:           yangyu
 * <p>
 * 日期:           2016年4月18日
 * <p>
 * 负责人:         liangjinjing
 * <p>
 * <p>
 */
public enum Status implements BaseEnum
{
    SUCCESS
    {
        public int getValue()
        {
            return 1;
        }
        public String getName()
        {
            return "成功";
        }
    },
    FAIL
    {
        public int getValue()
        {
            return 0;
        }
        public String getName()
        {
            return "失败";
        }
    };
}
