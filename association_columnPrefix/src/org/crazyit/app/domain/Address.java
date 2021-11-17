package org.crazyit.app.domain;

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
	private Person owner;
	private Person renter;

	// 无参数的构造器
	public Address()
	{
	}
	// 初始化全部成员变量的构造器
	public Address(Integer id, String detail, Person owner, Person renter)
	{
		this.id = id;
		this.detail = detail;
		this.owner = owner;
		this.renter = renter;
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

	// owner的setter和getter方法
	public void setOwner(Person owner)
	{
		this.owner = owner;
	}
	public Person getOwner()
	{
		return this.owner;
	}

	// renter的setter和getter方法
	public void setRenter(Person renter)
	{
		this.renter = renter;
	}
	public Person getRenter()
	{
		return this.renter;
	}

	@Override
	public String toString()
	{
		return "Address[id=" + this.id + ", detail="
			+ this.detail + ", owner=" + this.owner
			+ ", renter=" + this.renter + "]";
	}
}