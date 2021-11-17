package org.crazyit.app.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.ConstructorArgs;
import org.apache.ibatis.annotations.Arg;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Result;

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
public interface NewsMapper {
    @Select("select * from news_inf where news_title like #{title}")
    @ConstructorArgs({
            // 配置两个参数，表明调用带两个参数的构造器
            // 此处的配置顺序，决定了构造器参数的顺序：(Integer, String)
            // 指定id为true，相当于<idArg.../>子元素
            @Arg(column = "news_id", javaType = Integer.class, id = true),
            @Arg(column = "news_title", javaType = String.class)
    })
    @Results({
            @Result(column = "news_content", property = "content")
    })
    List<News> findNewsByTitle(String title);
}