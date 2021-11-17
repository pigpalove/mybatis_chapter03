package lee;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import org.crazyit.app.dao.PersonMapper;
import org.crazyit.app.dao.AddressMapper;
import org.crazyit.app.domain.Person;
import org.crazyit.app.domain.Address;

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
        selectAddress(sqlSession);

//        System.out.println("=========");
//        sqlSession = sqlSessionFactory.openSession();
//        selectPerson(sqlSession);
//        System.out.println("=========");
//        sqlSession = sqlSessionFactory.openSession();
//        selectPerson2(sqlSession);
    }

    public static void selectAddress(SqlSession sqlSession) {
        // 获取Mapper对象
        var addrMapper = sqlSession.getMapper(AddressMapper.class);
        // 调用Mapper对象的方法执行持久化操作
        var addr = addrMapper.getAddress(3); //地址的id
        System.out.println(addr.getDetail());
        // 访问关联实体
        addr.getPersons().forEach(System.out::println);
        // 提交事务
        sqlSession.commit();
        // 关闭资源
        sqlSession.close();
    }

    public static void selectPerson(SqlSession sqlSession) {
        // 获取Mapper对象
        var personMapper = sqlSession.getMapper(PersonMapper.class);
        // 调用Mapper对象的方法执行持久化操作
        var person = personMapper.getPerson(2);
        System.out.println(person.getName());
        person.getAddresses().forEach(addr -> {
            System.out.println(addr.getDetail());
        });
        // 提交事务
        sqlSession.commit();
        // 关闭资源
        sqlSession.close();
    }

    public static void selectPerson2(SqlSession sqlSession) {
        // 获取Mapper对象
        var personMapper = sqlSession.getMapper(PersonMapper.class);
        // 调用Mapper对象的方法执行持久化操作
        var personList = personMapper.findPersonById(2);
        personList.forEach(person -> {
            System.out.println(person.getName());
//			person.getAddresses().forEach(System.out::println);
        });
        // 提交事务
        sqlSession.commit();
        // 关闭资源
        sqlSession.close();
    }
}
