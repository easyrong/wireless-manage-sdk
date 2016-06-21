/*
 * 文件名称:          CapitalMarket.java
 * 版权所有@ 2014-2016 上海信隆行信息科技股份有限公司，保留所有权利
 * 编译器:           JDK1.7
 * 时间:             下午8:31:40
 */

package com.easyrong.mange.dictionary;

/**
 * 资本市场
 * <p>
 * <p>
 * Version:        V2.0
 * <p>
 * 作者:           liangjinjing
 * <p>
 * 日期:           2015年11月30日
 * <p>
 * 负责人:         liangjinjing
 * <p>
 * <p>
 */
public enum ErrorMessage implements BaseEnum
{
    OK
    {
        public int getValue()
        {
            return 200;
        }

        public String getName()
        {
            return "";
        }
    },
    ERR_IN_SYSTEM
    {
        public int getValue()
        {
            return 1;
        }

        public String getName()
        {
            return "系统错误";
        }
    },
    ERR_IN_DATA
    {
        public int getValue()
        {
            return 101;
        }

        public String getName()
        {
            return "数据错误";
        }
    }, 
    ERR_IN_REQUEST
    {
        public int getValue()
        {
            return 601;
        }

        public String getName()
        {
            return "网络请求失败";
        }
    },
    ERR_IN_REQUEST_CALCEL
    {
        public int getValue()
        {
            return 602;
        }

        public String getName()
        {
            return "网络请求取消";
        }
    };
    
}
