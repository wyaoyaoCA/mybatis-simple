package study.wyy.mybatis.sqlmapper;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import study.wyy.mybatis.sqlmapper.mapper.TbAddressMapper;
import study.wyy.mybatis.sqlmapper.mapper.TbUserMapper;
import study.wyy.mybatis.sqlmapper.mapper.TbUserMapper2;
import study.wyy.mybatis.sqlmapper.model.TbAddress;
import study.wyy.mybatis.sqlmapper.model.TbUser;
import study.wyy.mybatis.sqlmapper.model.TbUser2;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

/**
 * @author by wyaoyao
 * @Description
 * @Date 2021/1/31 3:04 下午
 */
public class SqlMapperTest3 {

    TbAddressMapper addressMapper;
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
        addressMapper = sqlSession.getMapper(TbAddressMapper.class);
        tbUserMapper = sqlSession.getMapper(TbUserMapper2.class);
    }

    @Test
    public void test01() {
        TbAddress address = addressMapper.selectById(1L);
        System.out.println(address);
    }

    @Test
    public void test02() {
        TbAddress address = addressMapper.selectById2(1L);
        System.out.println("get /user");
        address.getUser();
    }

    @Test
    public void test03() {
        TbUser tbUser = tbUserMapper.selectByIdWithAddress(1L);
        System.out.println(tbUser);
    }

    @Test
    public void test04() {
        TbUser tbUser = tbUserMapper.selectByIdWithAddress2(1L);
        System.out.println(tbUser);
    }

}
