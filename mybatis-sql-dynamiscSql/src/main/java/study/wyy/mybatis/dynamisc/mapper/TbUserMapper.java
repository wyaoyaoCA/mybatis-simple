package study.wyy.mybatis.dynamisc.mapper;


import org.apache.ibatis.annotations.Param;
import study.wyy.mybatis.dynamisc.model.TbUser;

import java.util.List;

/**
 * @author by wyaoyao
 * @Description
 * @Date 2021/1/30 9:58 下午
 */
public interface TbUserMapper {

    /****
     * 根据条件查询用户
     * @param tbUser
     * @return
     */
    List<TbUser> selectUser(TbUser tbUser);

    /****
     * 根据条件查询用户
     * @param tbUser
     * @return
     */
    List<TbUser> selectUser2(TbUser tbUser);

    /****
     * 根据条件查询用户
     * @param tbUser
     * @return
     */
    List<TbUser> selectUser3(TbUser tbUser);

    /****
     * 更新用户
     * @param tbUser
     * @return
     */
    Boolean update(TbUser tbUser);

    /****
     * 批量根据id查询
     * @param ids
     * @return
     */
    List selectByIds(@Param("ids") List<Long> ids);


    /****
     * 批量插入
     * @param tbUsers
     * @return
     */
    Boolean creates(@Param("tbUsers") List<TbUser> tbUsers);
}


