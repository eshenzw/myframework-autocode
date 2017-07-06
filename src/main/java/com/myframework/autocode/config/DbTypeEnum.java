package com.myframework.autocode.config;

/**
 * Created by zw on 2017/7/6.
 */
public enum DbTypeEnum
{
	MYSQL(1), SQLSERVER(2), ORACLE(3), POSTGRESQL(3);

	private int value;

	DbTypeEnum(int v)
	{
		this.value = v;
	}
}
