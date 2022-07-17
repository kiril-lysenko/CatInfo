package com.self.education.catinfo.api;

import com.self.education.catinfo.domain.Colors;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CatRequest {

    @NotBlank
    private String name;
    @NotNull
    private Colors color;
    @Min(value = 0, message = "Must be equal or greater than 0")
    @Max(value = 100, message = "Must be equal or less than 100")
    private Integer tailLength;
    @Min(value = 0, message = "Must be equal or greater than 0")
    @Max(value = 50, message = "Must be equal or less than 50")
    private Integer whiskersLength;
}
