package test.mybatis;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * author: 牛虻.
 * time:2018/2/4 0004
 * email:pettygadfly@gmail.com
 * doc:
 */
public class SessionFactory {

    public static SqlSessionFactory getSf(){
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
        BeanFactory factory = context;
        SqlSessionFactory sqlSessionFactory = (SqlSessionFactory) factory.getBean("sqlSessionFactory");
        return sqlSessionFactory;
    }
}
