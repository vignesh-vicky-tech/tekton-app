package com.example.domain.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class WebEntityNameVO {

    @ApiModelProperty("Web entity name")
    private String name;
}
