package io.github.talelin.latticy.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.github.talelin.autoconfigure.validator.EnumValue;
import io.github.talelin.latticy.common.enumeration.OnlineOrNotEnum;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Data
public class ActivityDTO {
    @NotBlank
    @Length(min = 1, max = 60)
    private String title;

    @NotBlank
    @Length(min = 1, max = 20)
    private String name;

    @Length(min = 1, max = 255)
    private String description;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "UTC")
    @NotNull
    private Date startTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "UTC")
    @NotNull
    private Date endTime;

    @Length(min = 1, max = 60)
    private String remark;

    @EnumValue(target = OnlineOrNotEnum.class)
    private Integer online;

    @NotBlank
    @Length(min = 1, max = 255)
    private String entranceImg;

    @NotBlank
    @Length(min = 1, max = 255)
    private String internalTopImg;

    private List<@Min(1) Integer> couponIds;

}
