package study.wyy.mybatis.dynamisc;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import study.wyy.mybatis.dynamisc.mapper.TbUserMapper;
import study.wyy.mybatis.dynamisc.model.TbUser;

import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Target;
import java.util.Arrays;
import java.util.List;

/**
 * @author by wyaoyao
 * @Description
 * @Date 2021/2/2 10:39 下午
 */
public class SqlMapperTest {

    TbUserMapper tbUserMapper;
    SqlSession sqlSession;

    @Before
    public void getMapper() throws IOException {
        // 加载全局配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        // 构建sqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        // 获取sqlSession
        sqlSession = sqlSessionFactory.openSession();
        // 生成Mapper接口的代理对象
        tbUserMapper = sqlSession.getMapper(TbUserMapper.class);
    }

    @Test
    public void test01() {
        TbUser user = new TbUser();
        user.setId(1L);
        user.setUsername("kobe");
        tbUserMapper.selectUser(user);
    }

    @Test
    public void test02() {
        TbUser user = new TbUser();
        //user.setId(1L);
        user.setUsername("kobe");
        tbUserMapper.selectUser(user);
    }

    @Test
    public void test03() {
        TbUser user = new TbUser();
        //user.setId(1L);
        user.setUsername("kobe");
        tbUserMapper.selectUser2(user);
    }

    @Test
    public void test04() {

        TbUser user = new TbUser();
        // 如果用户ID和用户名都为空，就是查询id=1  也就是otherwise相当于 switch case 的default分支
        // select * from tb_user WHERE id = 1
        tbUserMapper.selectUser3(user);
        // 如果用户ID为空，但是用户名不为空，就是根据用户名模糊查询
        // select * from tb_user WHERE username like '$'?'$'
        user.setUsername("t-mac");
        tbUserMapper.selectUser3(user);
        // 如果用户ID不为空，就是根据用户id查询
        // select * from tb_user WHERE id=?
        user.setId(2L);
        tbUserMapper.selectUser3(user);
    }

    @Test
    public void test05() {
        TbUser user = new TbUser();
        user.setId(1L);
        user.setUsername("kobe");
        tbUserMapper.update(user);
    }

    @Test
    public void test06() {
        List list = tbUserMapper.selectByIds(Arrays.asList(1L, 2L, 3L));
        System.out.println(list);
    }

    @Test
    public void test07() {
        TbUser tbUser = new TbUser();
        tbUser.setUsername("james");
        tbUser.setPassword("123213");
        tbUser.setPhone("13100001001");

        TbUser tbUser1 = new TbUser();
        tbUser1.setUsername("wade");
        tbUser1.setPassword("123213");
        tbUser1.setPhone("13100001001");
        tbUserMapper.creates(Arrays.asList(tbUser, tbUser1));
        sqlSession.commit();
    }
}
