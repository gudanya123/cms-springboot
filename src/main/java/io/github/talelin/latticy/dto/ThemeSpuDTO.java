package io.github.talelin.latticy.dto;

import lombok.Data;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
public class ThemeSpuDTO {
    @Positive
    @NotNull
    private Integer themeId;

    @Positive
    @NotNull
    private Integer spuId;
}
