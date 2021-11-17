package org.crazyit.app.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;
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
    @Results({
            // 指定id为true，相当于<id.../>子元素
            @Result(column = "news_id", property = "id", id = true),
            @Result(column = "news_title", property = "title"),
            @Result(column = "news_content", property = "content")
    })
    List<News> findNewsByTitle(String title);
}