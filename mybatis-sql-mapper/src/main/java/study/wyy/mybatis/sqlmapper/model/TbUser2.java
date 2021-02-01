package study.wyy.mybatis.sqlmapper.model;

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
public class TbUser2 implements Serializable {

    private Long id;
    private String name;
    private String password;
    private String mobile;
    private String createTime;
    private String updateTime;

}
