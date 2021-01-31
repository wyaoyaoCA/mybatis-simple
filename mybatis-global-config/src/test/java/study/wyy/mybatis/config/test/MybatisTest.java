package study.wyy.mybatis.config.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import study.wyy.mybatis.config.mapper.TbUserMapper;
import study.wyy.mybatis.config.mapper.TbUserMapperAnnotation;
import study.wyy.mybatis.config.model.TbUser;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author by wyaoyao
 * @Description
 * @Date 2021/1/30 8:39 下午
 */
public class MybatisTest {

    @Test
    public  void executeSql() throws IOException {
        // 1 构建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = buildSqlSessionFactoryFromXml();
        // 2 获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 3 执行sql
        /**
         *  参数一：sql的唯一标识（String类型） namespace + id
         *  参数二: s执行sql需要的参数（Object 类型）, 比如这里根据id查询，查询id唯一的user
         */
        TbUser user = sqlSession.selectOne("study.wyy.mybatis.config.mapper.TbUserMapper.selectById", 1);
        System.out.println(user);
        // 4 关闭sqlSession
        sqlSession.close();

    }

    @Test
    public  void executeSqlByMapper() throws IOException {
        // 1 构建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = buildSqlSessionFactoryFromXml();
        // 2 获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 3 获取接口的实现：mybatis使用动态代理为接口生成了实现
        TbUserMapper tbUserMapper = sqlSession.getMapper(TbUserMapper.class);
        TbUser user = tbUserMapper.selectById(1L);
        System.out.println(user);
        sqlSession.close();

    }

    @Test
    public  void executeSqlByAnnotation() throws IOException {
        // 1 构建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = buildSqlSessionFactoryFromXml();
        // 2 获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 3 获取接口的实现：mybatis使用动态代理为接口生成了实现
        TbUserMapperAnnotation tbUserMapper = sqlSession.getMapper(TbUserMapperAnnotation.class);
        TbUser user = tbUserMapper.selectById(1L);
        System.out.println(user);
        sqlSession.close();

    }

    public SqlSessionFactory buildSqlSessionFactoryFromXml() throws IOException {
        String resource = "mybatis-config.xml";
        // 1 加载配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream(resource);
        // 2 构建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        return sqlSessionFactory;
    }


    public SqlSession getSqlSession() throws IOException {
        SqlSessionFactory sqlSessionFactory = buildSqlSessionFactoryFromXml();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        return sqlSession;
    }

}
