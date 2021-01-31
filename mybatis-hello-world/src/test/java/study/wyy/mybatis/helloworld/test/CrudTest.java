package study.wyy.mybatis.helloworld.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Assert;
import org.junit.Test;
import study.wyy.mybatis.helloworld.mapper.TbUserMapper;
import study.wyy.mybatis.helloworld.model.TbUser;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * @author by wyaoyao
 * @Description
 * @Date 2021/1/31 10:39 上午
 */
public class CrudTest {
    @Test
    public  void testInsert() throws IOException {
        String resource = "mybatis-config.xml";
        // 1 加载配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream(resource);
        // 2 构建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        // 3 获取session
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 4 获取mapper接口的代理对象
        TbUserMapper tbUserMapper = sqlSession.getMapper(TbUserMapper.class);
        // 插入
        TbUser insert = new TbUser();
        insert.setUsername("t-mac");
        insert.setPassword("123456");
        insert.setPhone("13011112222");
        Integer row = tbUserMapper.insert(insert);
        System.out.println("row======>" + row);
        // 获取新数据的主键
        System.out.println("新数据的主键: " + insert.getId());
        // 不要忘记提交
        sqlSession.commit();
        // 查询
        TbUser selectResult = tbUserMapper.selectById(2L);
        System.out.println(selectResult);
    }

    @Test
    public  void testUpdate() throws IOException {
        String resource = "mybatis-config.xml";
        // 1 加载配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream(resource);
        // 2 构建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        // 3 获取session
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 4 获取mapper接口的代理对象
        TbUserMapper tbUserMapper = sqlSession.getMapper(TbUserMapper.class);
        // 查询
        TbUser selectResult = tbUserMapper.selectById(2L);
        System.out.println(selectResult);
        // 修改这条记录的username
        selectResult.setUsername("wade");
        Integer row = tbUserMapper.updateById(selectResult);
        System.out.println("row======>" + row);
        // 不要忘记提交
        sqlSession.commit();
        // 查询
        selectResult = tbUserMapper.selectById(2L);
        Assert.assertEquals("wade",selectResult.getUsername());
    }

    @Test
    public  void testCount() throws IOException {
        String resource = "mybatis-config.xml";
        // 1 加载配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream(resource);
        // 2 构建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        // 3 获取session
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 4 获取mapper接口的代理对象
        TbUserMapper tbUserMapper = sqlSession.getMapper(TbUserMapper.class);
        // 查询
        TbUser selectResult = tbUserMapper.selectById(2L);
        System.out.println(selectResult);
        Map<String,Object> map = new HashMap();
        map.put("id",selectResult.getId());
        map.put("username",selectResult.getUsername());
        map.put("phone",selectResult.getPhone());
        Long count = tbUserMapper.count(map);
        Assert.assertEquals(Long.valueOf(1L),count);
    }

    @Test
    public  void testDel() throws IOException {
        String resource = "mybatis-config.xml";
        // 1 加载配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream(resource);
        // 2 构建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        // 3 获取session
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 4 获取mapper接口的代理对象
        TbUserMapper tbUserMapper = sqlSession.getMapper(TbUserMapper.class);
        // 查询
        TbUser selectResult = tbUserMapper.selectById(2L);
        // 删除
        tbUserMapper.deleteById(selectResult.getId());
        sqlSession.commit();
        // 统计
        Map<String,Object> map = new HashMap();
        map.put("id",selectResult.getId());
        map.put("username",selectResult.getUsername());
        map.put("phone",selectResult.getPhone());
        Long count = tbUserMapper.count(map);
        Assert.assertEquals(Long.valueOf(0L),count);
    }



}
