package test.mybatis;

import com.bird.Util.IdGen;
import com.bird.Util.TimeUtil;
import com.bird.dao.ArticleDirDao;
import com.bird.domain.ArticleDir;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import java.util.List;

/**
 * author: 牛虻.
 * time:2018/2/4 0004
 * email:pettygadfly@gmail.com
 * doc:
 * 测试xml生成对不对
 * xml生成还有很多要改进的地方，还有基础接口也是
 * 测试请不要忘记关闭sql session
 */
public class DaoTest {

    @Test
    public void testSaveDao() {
        SqlSessionFactory ssf = SessionFactory.getSf();
        SqlSession sqlSession = ssf.openSession();
        ArticleDirDao dao = sqlSession.getMapper(ArticleDirDao.class);
        ArticleDir articleDir = new ArticleDir();
        articleDir.setId(IdGen.getId());
        articleDir.setCreateTime(TimeUtil.getDateStr());
        articleDir.setDirName("java核心");
        System.out.println(dao.saveObject(articleDir));
    }

    @Test
    public void testFindByIdDao() {
        SqlSessionFactory ssf = SessionFactory.getSf();
        SqlSession sqlSession = ssf.openSession();
        ArticleDirDao dao = sqlSession.getMapper(ArticleDirDao.class);
        dao.findById("c7a8473031f449f791475247d38e256f");
        List<ArticleDir> list = dao.findByIds(new String[]{"c7a8473031f449f791475247d38e256f"});
        System.out.println("查询的总数为" + list.size());
    }

    @Test
    public void testUpdateDao() {
        SqlSessionFactory ssf = SessionFactory.getSf();
        SqlSession sqlSession = ssf.openSession();
        ArticleDirDao dao = sqlSession.getMapper(ArticleDirDao.class);
        List<ArticleDir> list = dao.findByIds(new String[]{"c7a8473031f449f791475247d38e256f"});
        ArticleDir articleDir = list.get(0);
        articleDir.setUpdateTime(TimeUtil.getDateStr());
        dao.updateObject(articleDir);
    }

    @Test
    public void testDeleteDao() {
        SqlSessionFactory ssf = SessionFactory.getSf();
        SqlSession sqlSession = ssf.openSession();
        ArticleDirDao dao = sqlSession.getMapper(ArticleDirDao.class);
        dao.deleteByIds(new String[]{"0d986a1dd2bf4504946b65eab7254a76",
                "ad5645c2b0654837b081038acae8c5d6"});
        dao.deleteById("96a4b34758d44cb0b573b738a8732a32");
    }
}
