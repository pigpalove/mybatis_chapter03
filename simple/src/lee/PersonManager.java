package lee;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import org.crazyit.app.dao.PersonMapper;
import org.crazyit.app.domain.Person;

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
public class PersonManager {
    private static SqlSessionFactory sqlSessionFactory;

    public static void main(String[] args) throws Exception {
        var resource = "mybatis-config.xml";
        // 使用Resources工具从类加载路径下加载指定文件
        var inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder()
                .build(inputStream);
        // 打开Session
        var sqlSession = sqlSessionFactory.openSession();
        selectPerson(sqlSession);
    }

    public static void selectPerson(SqlSession sqlSession) {
        // 获取Mapper对象
        var personMapper = sqlSession.getMapper(PersonMapper.class);
        // 调用Mapper对象的方法执行持久化操作
        var personList = personMapper.findPersonByAge(20);
        System.out.println(personList);
        // 提交事务
        sqlSession.commit();
        // 关闭资源
        sqlSession.close();
    }
}
