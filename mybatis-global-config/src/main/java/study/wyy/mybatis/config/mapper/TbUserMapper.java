package study.wyy.mybatis.config.mapper;


import study.wyy.mybatis.config.model.TbUser;

/**
 * @author by wyaoyao
 * @Description
 * @Date 2021/1/30 9:58 下午
 */
public interface TbUserMapper {

    TbUser selectById(Long id);
}
