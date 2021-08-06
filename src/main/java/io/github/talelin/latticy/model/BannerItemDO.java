package io.github.talelin.latticy.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

@TableName("banner_item")
@Getter
@Setter
public class BannerItemDO extends BaseModel{
    private String name;

    private String img;

    private String keyword;

    private Integer type;

    //指定数据表里的映射
   // @TableField
    private Integer bannerId;
}
