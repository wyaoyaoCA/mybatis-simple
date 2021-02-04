package study.wyy.mybatis.cache.mapper;

import org.apache.ibatis.annotations.Param;
import study.wyy.mybatis.cache.model.TbUser;

/**
 * @author by wyaoyao
 * @Description
 * @Date 2021/1/30 9:58 下午
 */
public interface TbUserMapper {

    TbUser selectById(@Param("id") Long id);

}
