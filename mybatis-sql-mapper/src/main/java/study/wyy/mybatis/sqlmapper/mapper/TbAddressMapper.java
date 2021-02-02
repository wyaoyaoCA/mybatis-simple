package study.wyy.mybatis.sqlmapper.mapper;


import org.apache.ibatis.annotations.Param;
import study.wyy.mybatis.sqlmapper.model.TbAddress;

/**
 * @author by wyaoyao
 * @Description
 * @Date 2021/2/1 9:41 下午
 */

public interface TbAddressMapper {

    /**
     * 根据地址id查询地址
     */
    TbAddress selectById(@Param("id") Long id);


    /**
     * 根据地址id查询地址
     */
    TbAddress selectById2(@Param("id") Long id);


    /**
     * 根据地址id查询地址
     */
    //TbAddress selectByUserId(@Param("id") Long userId);
}
