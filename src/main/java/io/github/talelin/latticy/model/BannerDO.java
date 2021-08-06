package io.github.talelin.latticy.model;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@TableName("banner")
@Setter
@Getter
public class BannerDO extends BaseModel{

    private String name;

    private String description;

    private String title;

    private String img;


}
