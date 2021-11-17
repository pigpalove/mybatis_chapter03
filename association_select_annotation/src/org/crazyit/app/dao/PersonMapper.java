package org.crazyit.app.dao;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.mapping.FetchType;

import org.crazyit.app.domain.*;

/**
 * Description:<br>
 * 网站: <a href="http://www.crazyit.org">疯狂Java联盟</a><br>
 * Copyright (C), 2001-2020, Yeeku.H.Lee<br>
 * This program is protected by copyright laws.<br>
 * Program Name:<br>
 * Date:<br>
 *
 * @author Yeeku.H.Lee kongyeeku@163.com 公众号: fkbooks<br>
 * @version 1.0
 */
public interface PersonMapper {
    @Select("select * from person_inf where person_id=#{id}")
    @Results({
            @Result(column = "person_id", property = "id", id = true),
            @Result(column = "person_name", property = "name"),
            @Result(column = "person_age", property = "age"),
            @Result(property = "address", javaType = Address.class, column = "person_id",
                    one = @One(select = "org.crazyit.app.dao.AddressMapper.selectAddressByOwner", fetchType = FetchType.EAGER))
    })
    Person getPerson(Integer id);
}