package io.github.talelin.latticy.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.Date;

/**
 * @author Juzi@TaleLin
 */
@Data
public class BaseModel {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @JsonIgnore
    private Date createTime;

    @JsonIgnore
    private Date updateTime;
    /**
     * @TableLogic是 mybatis-plus 提供的逻辑删除（软删除）注解，有了该注解后，
     * 当你调用 API 删除某个 book 的时候，并不会真正的删除 book，
     * 而是将deleteTime设置为删除时间。
     */
    @TableLogic
    @JsonIgnore
    private Date deleteTime;
}
