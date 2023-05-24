package com.bguerra.inventory.response;

import com.bguerra.inventory.model.Category;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductResponseRest extends ResponseRest{

    private ProductResponse product = new ProductResponse();


    @ApiModelProperty(notes = "ID del producto")//swagger
    private Long id;

    @ApiModelProperty(notes = "Nombre del producto")//swagger
    private String name;

    @ApiModelProperty(notes = "Precio del producto")//swagger
    private int price;

    @ApiModelProperty(notes = "Cuenta del Usuario")//swagger
    private int account;

    @ApiModelProperty(notes = "ID de la categoria del producto")//swagger
    private Category category;

    @ApiModelProperty(notes = "Imagen del producto")//swagger
    private byte[] picture;
}
