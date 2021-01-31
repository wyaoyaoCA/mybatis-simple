package study.wyy.mybatis.helloworld.mapper;

import study.wyy.mybatis.helloworld.model.TbUser;

import java.util.Map;

/**
 * @author by wyaoyao
 * @Description
 * @Date 2021/1/30 9:58 下午
 */
public interface TbUserMapper {

    /**
        根据id查询
     */
    TbUser selectById(Long id);

    /****
     * 插入数据
     * @param user
     * @return 返回值是影响的行数
     */
    Integer insert(TbUser user);

    /****
     * 根据ID更新
     * @param user
     * @return 返回值是影响的行数
     */
    Integer updateById(TbUser user);

    /****
     * 根据ID删除
     * @param id
     * @return 返回值是影响的行数
     */
    Integer deleteById(Long id);


    /****
     * 统计 统计指定条件的数量
     * @param map: 查询条件
     * @return 返回值是数据总量
     */
    Long count(Map map);

}
