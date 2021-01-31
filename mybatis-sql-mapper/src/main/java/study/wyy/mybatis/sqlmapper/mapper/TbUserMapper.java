package study.wyy.mybatis.sqlmapper.mapper;


import org.apache.ibatis.annotations.Param;
import study.wyy.mybatis.sqlmapper.model.TbUser;

import java.util.List;
import java.util.Map;

/**
 * @author by wyaoyao
 * @Description
 * @Date 2021/1/30 9:58 下午
 */
public interface TbUserMapper {


    TbUser selectById(Long id);

    TbUser selectByUsernameAndPhone(String username,String phone);

    TbUser selectByUsernameAndPhone2(@Param("username") String username, @Param("phone") String phone);

    TbUser selectByPojo(TbUser tbUser);

    TbUser selectByMap(Map<String,Object> map);

    TbUser selectByIds(@Param("ids") List<Long> id);

    TbUser select1(@Param("id") Long id, String phone);

    TbUser select2(Long id, TbUser tbUser);

    TbUser select3(@Param("id") Long id, @Param("user") TbUser tbUser);

    TbUser select4(Long id,String phone);

    TbUser select5(@Param("username") String username, @Param("phone") String phone);

    TbUser selectLike(@Param("username") String username, @Param("phone") String phone);

    TbUser select6(@Param("tableName") String tableName, @Param("id") Long id);
}
