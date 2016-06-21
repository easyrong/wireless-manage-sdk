/*
 * 文件名称:          Kit.java
 * 版权所有@ 2014-2016 上海信隆行信息科技股份有限公司，保留所有权利
 * 编译器:           JDK1.7
 * 时间:             上午10:31:10
 */

package com.easyrong.mange.utils;

import java.lang.reflect.Field;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.easyrong.mange.common.ERLoggerManage;

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
public class Kit
{

    /**
     * Bean到JSON
     *
     * @param jsonObject
     * @param bean
     */
    public static JSONObject beanToJSONObject(Object bean)
    {
        JSONObject json = new JSONObject();
        try
        {   
            Field[] fields =bean.getClass().getDeclaredFields();
            if (fields != null)
            {
                for (Field f : fields)
                {
                    f.setAccessible(true);
                    Object object = f.get(bean);
                    if (object != null)
                    {
                        // int数据
                        if (object instanceof int[])
                        {
                            int[] arrays = (int[])object;
                            JSONArray jsonArray = new JSONArray();
                            for (int a : arrays)
                            {
                                jsonArray.add(a);
                            }
                            json.put(f.getName(), jsonArray);
                        }
                        // 字符串数据
                        else if (object instanceof String[])
                        {
                            String[] arrays = (String[])object;
                            JSONArray jsonArray = new JSONArray();
                            for (String s : arrays)
                            {
                                jsonArray.add(s);
                            }
                            json.put(f.getName(), jsonArray);
                        }
                        else
                        {
                            json.put(f.getName(), object);
                        }
                    }
                }
            }
        }
        catch(Exception e)
        {
            ERLoggerManage.info(Kit.class, e.getMessage(), e);
        }
        return json;
    }

    /**
     * Bean到String
     *
     * @param bean
     */
    public static String beanToString(Class<?> clz)
    {
        String str = "";
        try
        {
            Class<?> c = clz.getClass();
            Field[] fields = c.getDeclaredFields();
            if (fields != null)
            {
                for (Field f : fields)
                {
                    f.setAccessible(true);
                    str += f.getName() + "=" + f.get(clz) + ", ";
                }
            }
        }
        catch(Exception e)
        {
            str = clz.toString();
        }
        return str;
    }
}
