package com.example.domain.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel("Web entity")
@Data
public class WebEntityVO {

    @ApiModelProperty("Web entity id")
    private Long id;
    @ApiModelProperty("Web entity first name")
    private String firstName;
    @ApiModelProperty("Web entity last name")
    private String lastName;
    @ApiModelProperty("Web entity middle name")
    private String middleName;
}
