package study.wyy.mybatis.sqlmapper.mapper;


import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;
import study.wyy.mybatis.sqlmapper.model.TbUser;
import study.wyy.mybatis.sqlmapper.model.TbUser2;

import java.util.List;
import java.util.Map;

/**
 * @author by wyaoyao
 * @Description
 * @Date 2021/1/30 9:58 下午
 */
public interface TbUserMapper2 {

    List<TbUser> selectAll();

    Map<String, Object> selectById(@Param("id") Long id);


    @MapKey("id")
    Map<Long, TbUser> selectMap();


    TbUser2 select1(@Param("id") Long id);

    TbUser selectByIdWithAddress(@Param("id") Long id);

    TbUser selectByIdWithAddress2(@Param("id") Long id);


}
