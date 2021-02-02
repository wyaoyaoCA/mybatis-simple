package study.wyy.mybatis.sqlmapper.model;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/**
 * @author by wyaoyao
 * @Description
 * @Date 2021/1/30 8:34 下午
 */
@Data
@ToString
public class TbUser implements Serializable {

    private Long id;
    private String username;
    private String password;
    private String phone;
    private String createTime;
    private String updateTime;
    // 用户关联的地址
    private List<TbAddress> addresses;

}
