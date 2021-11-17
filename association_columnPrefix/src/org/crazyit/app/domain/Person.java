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
public class Person
{
	private Integer id;
	private String name;
	private int age;
	private Address ownerAddr;
	private Address rentalAddr;

	// 无参数的构造器
	public Person()
	{
	}
	// 初始化全部成员变量的构造器
	public Person(Integer id, String name, int age,
		Address ownerAddr, Address rentalAddr)
	{
		this.id = id;
		this.name = name;
		this.age = age;
		this.ownerAddr = ownerAddr;
		this.rentalAddr = rentalAddr;
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

	// name的setter和getter方法
	public void setName(String name)
	{
		this.name = name;
	}
	public String getName()
	{
		return this.name;
	}

	// age的setter和getter方法
	public void setAge(int age)
	{
		this.age = age;
	}
	public int getAge()
	{
		return this.age;
	}

	// ownerAddr的setter和getter方法
	public void setOwnerAddr(Address ownerAddr)
	{
		this.ownerAddr = ownerAddr;
	}
	public Address getOwnerAddr()
	{
		return this.ownerAddr;
	}

	// rentalAddr的setter和getter方法
	public void setRentalAddr(Address rentalAddr)
	{
		this.rentalAddr = rentalAddr;
	}
	public Address getRentalAddr()
	{
		return this.rentalAddr;
	}

	@Override
	public String toString()
	{
		return "Person[id=" + this.id + ", name="
			+ this.name + ", age=" + this.age + "]";
	}
}