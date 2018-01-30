package test.mybatis;

import com.bird.dao.UserDao;
import com.bird.domain.User;
import com.bird.service.base.BaseService;
import com.bird.service.user.UserService;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionManager;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import java.util.List;
import java.util.UUID;

/**
 * author: 牛虻.
 * time:2018/1/30
 * email:pettygadfly@gmail.com
 * doc:
 * 一级缓存测试,
 */
public class CacheTest<E> {

    //缓存测试
    @Test
    public void test() {
//       Resource resource = new FileSystemResource("beans.xml");
//       BeanFactory factory = new XmlBeanFactory(resource);
//       ClassPathResource resource = new ClassPathResource("beans.xml");
//       BeanFactory factory = new XmlBeanFactory(resource);
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
        BeanFactory factory = context;
        SqlSessionFactory sqlSessionFactory = (SqlSessionFactory) factory.getBean("sqlSessionFactory");
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        UserDao dao = sqlSession.getMapper(UserDao.class);
        User u = new User();
        u.setId("2fab62a5-1105-413e-8082-e9d11430368d");
        System.out.println(dao.getUser(u));
        System.out.println(dao.getUser(u));
        System.out.println(dao.getUser(u));
        u.setName(Math.random() + "");
        dao.update(u);
        System.out.println(dao.getUser(u));
    }


    //框架测试
    @Test
    public void testBaseDao() {
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
        BeanFactory factory = context;
        SqlSessionFactory sqlSessionFactory = (SqlSessionFactory) factory.getBean("sqlSessionFactory");
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        UserDao dao = sqlSession.getMapper(UserDao.class);
        User u = new User();
        u.setId(UUID.randomUUID().toString());
        u.setName(Math.random() + "");
        System.out.println(dao.saveObject(u));
    }

    //框架测试
    @Test
    public void testBaseService() {
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
        BeanFactory factory = context;
        UserService userService = (UserService) factory.getBean("userService");
        User u = new User();
        u.setId(UUID.randomUUID().toString());
        u.setName("ABSDFSDF");
        userService.saveObject(u);
    }
}
