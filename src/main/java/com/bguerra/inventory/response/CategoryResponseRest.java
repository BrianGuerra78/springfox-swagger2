package com.bguerra.inventory.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryResponseRest extends ResponseRest{

    private CategoryResponse categoryResponse = new CategoryResponse();

    @ApiModelProperty(notes = "ID de la categoria")//swagger
    private Long id;

    @ApiModelProperty(notes = "Nombre de la categoria")//swagger
    private String name;

    @ApiModelProperty(notes = "Descripcion de la categoria")//swagger
    private String description;


}
