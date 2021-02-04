package study.wyy.mybatis.cache.model;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

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

}
