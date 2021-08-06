package io.github.talelin.latticy.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author pedro@TaleLin
 * @author Juzi@TaleLin
 */
@Data
@TableName("book")
@EqualsAndHashCode(callSuper = true)
@Setter
@Getter
public class BookDO extends BaseModel implements Serializable {

    private static final long serialVersionUID = 3531805912578317266L;

    private String title;

    private String author;

    private String summary;

    private String image;
}
