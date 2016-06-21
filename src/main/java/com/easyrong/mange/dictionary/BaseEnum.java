/*
 * 文件名称:          BaseEnum.java
 * 版权所有@ 2014-2016 上海信隆行信息科技股份有限公司，保留所有权利
 * 编译器:           JDK1.7
 * 时间:             下午7:16:38
 */
package com.easyrong.mange.dictionary;

/**
 *  数据字典枚举的接口,所有的数据字典都用枚举实现，并且需要实现BaseEnum接口
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
public interface BaseEnum
{
    // 显示的名称
    public String getName();
    // 名称对应的值
    public int getValue();
}
