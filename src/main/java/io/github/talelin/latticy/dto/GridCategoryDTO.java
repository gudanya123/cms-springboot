package io.github.talelin.latticy.dto;

import lombok.Data;
import lombok.Getter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
@Getter
public class GridCategoryDTO {
    @Length(min = 1, max = 100)
    private String title;

    @Length(min = 1, max = 100)
    private String name;

    @NotBlank
    @Length(min = 1, max = 255)
    private String img;

    @NotNull
    @Positive
    private Integer categoryId;
}
