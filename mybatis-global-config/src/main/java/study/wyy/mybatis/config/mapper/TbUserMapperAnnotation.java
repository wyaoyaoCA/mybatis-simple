package study.wyy.mybatis.config.mapper;


import org.apache.ibatis.annotations.Select;
import study.wyy.mybatis.config.model.TbUser;

/**
 * @author by wyaoyao
 * @Description
 * @Date 2021/1/30 9:58 下午
 */
public interface TbUserMapperAnnotation {

    @Select(" select * from tb_user where id = #{id}")
    TbUser selectById(Long id);
}
