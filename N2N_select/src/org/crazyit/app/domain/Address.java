package org.crazyit.app.domain;

import java.util.List;

/**
 * Description:<br>
 * 网站: <a href="http://www.crazyit.org">疯狂Java联盟</a><br>
 * Copyright (C), 2001-2020, Yeeku.H.Lee<br>
 * This program is protected by copyright laws.<br>
 * Program Name:<br>
 * Date:<br>
 * @author Yeeku.H.Lee kongyeeku@163.com 公众号: fkbooks<br>
 * @version 1.0
 */
public class Address
{
	private Integer id;
	// 定义地址详细信息的成员变量
	private String detail;
	private List<Person> persons;

	// 无参数的构造器
	public Address()
	{
	}
	// 初始化全部成员变量的构造器
	public Address(Integer id, String detail)
	{
		this.id = id;
		this.detail = detail;
	}

	// id的setter和getter方法
	public void setId(Integer id)
	{
		this.id = id;
	}
	public Integer getId()
	{
		return this.id;
	}

	// detail的setter和getter方法
	public void setDetail(String detail)
	{
		this.detail = detail;
	}
	public String getDetail()
	{
		return this.detail;
	}

	// persons的setter和getter方法
	public void setPersons(List<Person> persons)
	{
		this.persons = persons;
	}
	public List<Person> getPersons()
	{
		return this.persons;
	}

	@Override
	public String toString()
	{
		return "Address[id=" + this.id + ", detail=" + this.detail + "]";
	}
}