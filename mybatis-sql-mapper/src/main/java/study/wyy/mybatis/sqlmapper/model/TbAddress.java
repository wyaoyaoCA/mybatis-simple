package study.wyy.mybatis.sqlmapper.model;

import lombok.Data;
import lombok.ToString;

/**
 * @author by wyaoyao
 * @Description
 * @Date 2021/2/1 9:41 下午
 */
@Data
@ToString
public class TbAddress {
    private Long id;
    private String province;
    private String city;
    private String detail;
    private String createTime;
    private String updateTime;
    // 关联的用户信息
    private TbUser user;

}
