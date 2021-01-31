package study.wyy.mybatis.sqlmapper;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import study.wyy.mybatis.sqlmapper.mapper.TbUserMapper;
import study.wyy.mybatis.sqlmapper.model.TbUser;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author by wyaoyao
 * @Description
 * @Date 2021/1/31 3:04 下午
 */
public class SqlMapperTest {

    TbUserMapper tbUserMapper;

    @Before
    public void getMapper() throws IOException {
        // 加载全局配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        // 构建sqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        // 获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 生成Mapper接口的代理对象
        tbUserMapper = sqlSession.getMapper(TbUserMapper.class);
    }

    @Test
    public void test01() {
        TbUser tbUser = tbUserMapper.selectById(1L);
        System.out.println(tbUser);
    }

    @Test
    public void test02() {
        TbUser tbUser = tbUserMapper.selectByUsernameAndPhone("kobe", "13100001111");
        System.out.println(tbUser);
    }


    @Test
    public void test03() {
        TbUser tbUser = tbUserMapper.selectByUsernameAndPhone2("kobe", "13100001111");
        System.out.println(tbUser);
    }

    @Test
    public void test04() {
        TbUser user = new TbUser();
        user.setUsername("kobe");
        user.setPhone("13100001111");
        TbUser tbUser = tbUserMapper.selectByPojo(user);
        System.out.println(tbUser);
    }

    @Test
    public void test05() {

        Map<String, Object> map = new HashMap<>();
        map.put("username", "kobe");
        map.put("phone", "13100001111");
        TbUser tbUser = tbUserMapper.selectByMap(map);
        System.out.println(tbUser);
    }

    @Test
    public void test06() {
        List<Long> ids = new ArrayList<>();
        ids.add(1L);
        TbUser tbUser = tbUserMapper.selectByIds(ids);
        System.out.println(tbUser);
    }

    @Test
    public void test07() {
        TbUser tbUser = tbUserMapper.select1(1L,"13100001111");
        System.out.println(tbUser);
        TbUser user = new TbUser();
        user.setPhone("13100001111");
        tbUser = tbUserMapper.select2(1L,user);
        System.out.println(tbUser);
        tbUser = tbUserMapper.select3(1L,user);
        System.out.println(tbUser);
    }

    @Test
    public void test08() {
        TbUser tbUser = tbUserMapper.select4(1L,"13100001111");
        System.out.println(tbUser);

    }

    @Test
    public void test09() {
        TbUser tbUser = tbUserMapper.select5("kobe","13100001111");
        System.out.println(tbUser);
    }

    @Test
    public void test10() {
        TbUser tbUser = tbUserMapper.selectLike("kobe","13100001111");
        System.out.println(tbUser);
    }

    @Test
    public void test11() {
        TbUser tbUser = tbUserMapper.select6("tb_user",1L);
        System.out.println(tbUser);
    }
}
