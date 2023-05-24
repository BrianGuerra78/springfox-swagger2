package com.bguerra.inventory.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Schema(name = "category", description = "Modelo que representa a invocar a la base de datos")
@Table(name = "category")
public class Category implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Schema(name = "name", required = true, example = "verduras", description = "Nombre de la categoria a asignar")//swagger
    private String name;

    @Schema(name = "descripcion", required = true, example = "verduras", description = "Descripcion sobre la categoria a asignar")//swagger
    private String description;

}
