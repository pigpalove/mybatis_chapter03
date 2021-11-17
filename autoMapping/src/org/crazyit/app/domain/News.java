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
public class News
{
	private Integer newsId;
	private String newsTitle;
	private String content;
//	private String newsContent;

	// 无参数的构造器
	public News()
	{
	}
	// 初始化全部成员变量的构造器
	public News(Integer newsId, String newsTitle, String content)
	{
		this.newsId = newsId;
		this.newsTitle = newsTitle;
		this.content = content;
	}

	// newsId的setter和getter方法
	public void setNewsId(Integer newsId)
	{
		this.newsId = newsId;
	}
	public Integer getNewsId()
	{
		return this.newsId;
	}

	// newsTitle的setter和getter方法
	public void setNewsTitle(String newsTitle)
	{
		this.newsTitle = newsTitle;
	}
	public String getNewsTitle()
	{
		return this.newsTitle;
	}

	// content的setter和getter方法
	public void setContent(String content)
	{
		this.content = content;
	}
	public String getContent()
	{
		return this.content;
	}

	@Override
	public String toString()
	{
		return "News[newsId=" + this.newsId + ", newsTitle="
			+ this.newsTitle + ", content=" + this.content + "]";
	}
}