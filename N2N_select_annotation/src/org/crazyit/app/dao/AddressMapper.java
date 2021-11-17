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
 *
 * @author Yeeku.H.Lee kongyeeku@163.com 公众号: fkbooks<br>
 * @version 1.0
 */
public interface AddressMapper {
    @Select("select * from address_inf where addr_id=#{id}")
    @Results(id = "addressMap", value = {
            @Result(column = "addr_id", property = "id", id = true),
            @Result(column = "addr_detail", property = "detail"),
            @Result(column = "addr_id", property = "persons",
                    javaType = ArrayList.class,
                    many = @Many(select = "org.crazyit.app.dao.PersonMapper.findPersonByAddr",
                            fetchType = FetchType.LAZY))
    })
    Address getAddress(Integer id);


    @Select("select a.* from address_inf a " +
            "join person_address pa " +
            "on a.addr_id = pa.address_id " +
            "where pa.owner_id=#{id}")
    @ResultMap("addressMap")
    List<Address> findAddressByOwner(Integer id);
}