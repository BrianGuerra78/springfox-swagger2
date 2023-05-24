package com.bguerra.inventory.controller;

import com.bguerra.inventory.model.Category;
import com.bguerra.inventory.response.CategoryResponseRest;
import com.bguerra.inventory.services.ICategoryService;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api/v1")
@Api(value = "Categorias CRUD", description = "CRUD Categorias")//swagger
public class CategoryRestController {

    @Autowired
    private ICategoryService service;

    //swagger
    @Operation(summary = "Buscar todas las categorias")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Categorias encontradas",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Category.class))}),
            @ApiResponse(responseCode = "400", description = "Categorias invalidas", content = @Content),
            @ApiResponse(responseCode = "401", description = "No tiene autorizacion", content = @Content),
            @ApiResponse(responseCode = "403", description = "Prohibido", content = @Content),
            @ApiResponse(responseCode = "404", description = "Categorias no encontradas", content = @Content)
    })//swagger
    @GetMapping("/categories")// get all the categories
    public ResponseEntity<CategoryResponseRest> searchCategories(){
        ResponseEntity<CategoryResponseRest> response = service.search();
        return response;
    }

    //swagger
    @Operation(summary = "Buscar una categoria por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Categoria encontrada",
            content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Category.class))}),
            @ApiResponse(responseCode = "400", description = "Categoria invalida", content = @Content),
            @ApiResponse(responseCode = "401", description = "No tiene autorizacion", content = @Content),
            @ApiResponse(responseCode = "403", description = "Prohibido", content = @Content),
            @ApiResponse(responseCode = "404", description = "Categoria no encontrada", content = @Content)
    })//swagger
    @GetMapping("/categories/{id}")//get categori by id
    public ResponseEntity<CategoryResponseRest> searchCategoriesById(@PathVariable Long id){
        ResponseEntity<CategoryResponseRest> response = service.searchById(id);
        return response;
    }

    //swagger
    @Operation(summary = "Guardar Categoria")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Categoria Guardada",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Category.class))}),
            @ApiResponse(responseCode = "400", description = "Categoria invalida", content = @Content),
            @ApiResponse(responseCode = "401", description = "No tiene autorizacion", content = @Content),
            @ApiResponse(responseCode = "403", description = "Prohibido", content = @Content),
            @ApiResponse(responseCode = "404", description = "Categoria no guardada", content = @Content)
    })//swagger
    @PostMapping("/categories")//save categories
    public ResponseEntity<CategoryResponseRest> save(@RequestBody Category category) {
        ResponseEntity<CategoryResponseRest> response = service.save(category);
        return response;
    }


    //swagger
    @Operation(summary = "Actualizar una Categoria")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Categoria actualizada",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Category.class))}),
            @ApiResponse(responseCode = "400", description = "Categoria invalida", content = @Content),
            @ApiResponse(responseCode = "401", description = "No tiene autorizacion", content = @Content),
            @ApiResponse(responseCode = "403", description = "Prohibido", content = @Content),
            @ApiResponse(responseCode = "404", description = "Categoria no actualizada", content = @Content)
    })//swagger
    @PutMapping("/categories/{id}")// update categories
    public ResponseEntity<CategoryResponseRest> update(@RequestBody Category category, @PathVariable Long id) {
        ResponseEntity<CategoryResponseRest> response = service.update(category, id);
        return response;
    }


    //swagger
    @Operation(summary = "Eliminar una categoria")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Categoria eliminada",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Category.class))}),
            @ApiResponse(responseCode = "400", description = "Categoria invalida", content = @Content),
            @ApiResponse(responseCode = "401", description = "No tiene autorizacion", content = @Content),
            @ApiResponse(responseCode = "403", description = "Prohibido", content = @Content),
            @ApiResponse(responseCode = "404", description = "Categoria no eliminada", content = @Content)
    })//swagger
    @DeleteMapping("/categories/{id}")// delete categories
    public ResponseEntity<CategoryResponseRest> delete(@PathVariable Long id) {
        ResponseEntity<CategoryResponseRest> response = service.deleteById(id);
        return response;
    }

}
