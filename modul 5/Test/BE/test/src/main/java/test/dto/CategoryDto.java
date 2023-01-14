package test.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class CategoryDto {
    private Integer id;

    @NotBlank
    @Min(value = 0,message = "Số lượng phải lớn hơn 0")
    private Integer number;
    @NotBlank
    private String productDay;
    @NotBlank
    private String startDay;
    @NotBlank
    private String endDay;

}
