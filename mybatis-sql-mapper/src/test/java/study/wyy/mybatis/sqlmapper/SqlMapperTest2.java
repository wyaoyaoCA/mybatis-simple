package study.wyy.mybatis.sqlmapper;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import study.wyy.mybatis.sqlmapper.mapper.TbUserMapper;
import study.wyy.mybatis.sqlmapper.mapper.TbUserMapper2;
import study.wyy.mybatis.sqlmapper.model.TbUser;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * @author by wyaoyao
 * @Description
 * @Date 2021/1/31 3:04 下午
 */
public class SqlMapperTest2 {

    TbUserMapper2 tbUserMapper;

    @Before
    public void getMapper() throws IOException {
        // 加载全局配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        // 构建sqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        // 获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 生成Mapper接口的代理对象
        tbUserMapper = sqlSession.getMapper(TbUserMapper2.class);
    }

    @Test
    public void test01() {
        List<TbUser> list = tbUserMapper.selectAll();
        System.out.println(list);
    }

    @Test
    public void test02() {
        Map<String, Object> map = tbUserMapper.selectById(1L);
        System.out.println(map);
    }

    @Test
    public void test03() {
        Map<Long, TbUser> map = tbUserMapper.selectMap();
        for (Long id : map.keySet()) {
            System.out.println(id + "--->" + map.get(id));
        }
    }


}
