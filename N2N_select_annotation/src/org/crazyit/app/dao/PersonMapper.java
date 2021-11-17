package org.crazyit.app.dao;

import java.util.List;
import java.util.ArrayList;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.mapping.FetchType;

import org.crazyit.app.domain.*;

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
public interface PersonMapper
{
	@Select("select * from person_inf where person_id=#{id}")
	@Results(id = "personMap",
		value = {
		@Result(column = "person_id", property = "id", id = true),
		@Result(column = "person_name", property = "name"),
		@Result(column = "person_age", property = "age"),
		@Result(column = "person_id", property = "addresses",
			javaType = ArrayList.class,
			many = @Many(select = "org.crazyit.app.dao.AddressMapper.findAddressByOwner",
			fetchType = FetchType.LAZY))
	})
	Person getPerson(Integer id);

	@Select("select * from person_inf where person_id>#{id}")
	@ResultMap("personMap")
	List<Person> findPersonById(Integer id);

	@Select("select p.* from person_inf p " +
		"join person_address pa " +
		"on p.person_id = pa.owner_id " +
		"where pa.address_id=#{id}")
	@ResultMap("personMap")
	List<Person> findPersonByAddr(Integer id);
}