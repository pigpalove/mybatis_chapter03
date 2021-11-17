package org.crazyit.app.domain;

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
public class Customer extends Person {
    private String comments;

    // 无参数的构造器
    public Customer() {
    }

    // 初始化全部成员变量的构造器
    public Customer(String comments) {
        this.comments = comments;
    }

    // comments的setter和getter方法
    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getComments() {
        return this.comments;
    }

    @Override
    public String toString() {
        return "Customer[id=" + super.getId() + ", name=" + super.getName()
                + ", age=" + super.getAge() + ", comments=" + this.comments + "]";
    }
}