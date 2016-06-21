/*
 * 文件名称:          NullJudge.java
 * 版权所有@ 2014-2016 上海信隆行信息科技股份有限公司，保留所有权利
 * 编译器:           JDK1.7
 * 时间:             下午8:41:44
 */

package com.easyrong.mange.utils;

/**
 * Null校验工具类
 * <p>
 * <p>
 * Version:        V2.0
 * <p>
 * 作者:           yangyu
 * <p>
 * 日期:           2015年11月9日
 * <p>
 * 负责人:         liangjinjing
 * <p>
 * <p>
 */
public class NullJudge
{
    /**
     * NullJudge工具类实例
     */
    private static NullJudge instance = new NullJudge();

    private NullJudge()
    {
    }

    /**
     * NullJudge工具类实例获取
     * @return NullJudge
     */
    public static NullJudge instance()
    {
        return instance;
    }

    /**
     * 字符串数组
     * 
     * @param s 判断对象集合
     * @return boolean true:有空字符串/false:无空字符串
     */
    public boolean judgeSZ(String[] s)
    {
        // 遍历判断对象集合
        for (int i = 0; i < s.length; i++)
        {
            // 对象为空的场合
            if (this.judgeString(s[i]))
            {
                return true;
            }
        }
        return false;
    }
    
    /**
     * 字符串数组
     * 
     * @param s 判断对象集合
     * @return boolean true:有空字符串/false:无空字符串
     */
    public boolean judgeSzAllNull(String[] s)
    {
        // 遍历判断对象集合
        for (int i = 0; i < s.length; i++)
        {
            // 对象为空的场合
            if (!this.judgeString(s[i]))
            {
                return false;
            }
        }
        return true;
    }

    /**
     * 包装对象数组
     * 
     * @param objs 判断对象集合
     * @return boolean true:有空对象/false:无对象
     */
    public boolean judgeSZ(Object[] objs)
    {
        if (objs == null)
        {
            return false;
        }
        // 遍历判断对象集合
        for (int i = 0; i < objs.length; i++)
        {
            // 对象为空的场合
            if (this.judgeObj(objs[i]))
            {
                return true;
            }
        }
        return false;
    }

    /**
     * 字符串
     * 
     * @param s 判断对象
     * @return boolean true:字符串为空/false:字符串不为空
     */
    public boolean judgeString(String s)
    {
        // 对象为空的场合
        return (s == null || s.length() == 0);
    }

    /**
     * 包装对象
     * 
     * @param obj 判断对象
     * @return boolean true:对象为空/false:对象不为空
     */
    public boolean judgeObj(Object obj)
    {
        if (obj == null)
        {
            return true;
        }
        // 数组
        if (obj.getClass().isArray())
        {
            Object[] arrObj = (Object[])obj;
            return arrObj.length == 0;
        }
        else
        {
            return "".equals(obj);
        }

    }
}
