package study.wyy.mybatis.cache.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import study.wyy.mybatis.cache.mapper.TbUserMapper;
import study.wyy.mybatis.cache.model.TbUser;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author by wyaoyao
 * @Description
 * @Date 2021/2/3 10:47 下午
 */
public class Test01 {

    @Test
    public void test() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        // 2 构建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        TbUserMapper tbUserMapper = sqlSession.getMapper(TbUserMapper.class);
        TbUser tbUser1 = tbUserMapper.selectById(1L);
        TbUser tbUser2 = tbUserMapper.selectById(1L);
        System.out.println(tbUser1);
        System.out.println(tbUser2);
        System.out.println(tbUser1 == tbUser2);
    }


    @Test
    public void test2() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        // 2 构建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        TbUserMapper tbUserMapper = sqlSession.getMapper(TbUserMapper.class);
        TbUser tbUser1 = tbUserMapper.selectById(1L);
        // 重新打开一个Session
        sqlSession = sqlSessionFactory.openSession();
        tbUserMapper = sqlSession.getMapper(TbUserMapper.class);
        TbUser tbUser2 = tbUserMapper.selectById(1L);
        System.out.println(tbUser1);
        System.out.println(tbUser2);
        System.out.println(tbUser1 == tbUser2);
    }


    @Test
    public void test3() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        // 2 构建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        TbUserMapper tbUserMapper = sqlSession.getMapper(TbUserMapper.class);
        TbUser tbUser1 = tbUserMapper.selectById(1L);
        // 清除缓存
        sqlSession.clearCache();
        TbUser tbUser2 = tbUserMapper.selectById(1L);
        System.out.println(tbUser1);
        System.out.println(tbUser2);
        System.out.println(tbUser1 == tbUser2);
    }

    @Test
    public void test4() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        // 2 构建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession1 = sqlSessionFactory.openSession();
        TbUserMapper tbUserMapper1 = sqlSession1.getMapper(TbUserMapper.class);
        TbUser tbUser1 = tbUserMapper1.selectById(1L);
        // 二级缓存在 SqlSession 关闭或提交之后才会生效
        sqlSession1.close();
        // 重新打开一个Session
        SqlSession sqlSession2 = sqlSessionFactory.openSession();
        TbUserMapper tbUserMapper2 = sqlSession2.getMapper(TbUserMapper.class);
        TbUser tbUser2 = tbUserMapper2.selectById(1L);
        sqlSession2.close();
        System.out.println(tbUser1);
        System.out.println(tbUser2);
        System.out.println(tbUser1 == tbUser2);
    }

    //TbUser(id=1, username=哈哈哈哈哈哈哈哈哈哈, password=123456, phone=13100001111, createTime=2019-04-04 22:58:26.0, updateTime=2019-04-04 22:58:26.0)
    // TbUser(id=1, username=kobe, password=123456, phone=13100001111, createTime=2019-04-04 22:58:26.0, updateTime=2019-04-04 22:58:26.0)
    @Test
    public void test5() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        // 2 构建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession1 = sqlSessionFactory.openSession();
        TbUserMapper tbUserMapper1 = sqlSession1.getMapper(TbUserMapper.class);
        TbUser tbUser1 = tbUserMapper1.selectById(1L);
        // 二级缓存在 SqlSession 关闭或提交之后才会生效
        sqlSession1.close();
        // 修改一下数据
        tbUser1.setUsername("哈哈哈哈哈哈哈哈哈哈");
        // 重新打开一个Session
        SqlSession sqlSession2 = sqlSessionFactory.openSession();
        TbUserMapper tbUserMapper2 = sqlSession2.getMapper(TbUserMapper.class);
        TbUser tbUser2 = tbUserMapper2.selectById(1L);
        sqlSession2.close();
        System.out.println(tbUser1);
        System.out.println(tbUser2);
        System.out.println(tbUser1 == tbUser2);
    }
}
