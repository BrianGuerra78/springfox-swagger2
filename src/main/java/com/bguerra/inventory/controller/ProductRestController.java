package com.bguerra.inventory.controller;

import com.bguerra.inventory.model.Category;
import com.bguerra.inventory.model.Product;
import com.bguerra.inventory.response.ProductResponseRest;
import com.bguerra.inventory.services.IProductService;
import com.bguerra.inventory.util.Util;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api/v1")
@Api(value = "Productos CRUD", description = "CRUD Productos")//swagger
public class ProductRestController {

    private IProductService productService;

    public ProductRestController(IProductService productService) {
        this.productService = productService;
    }


    //swagger
    @Operation(summary = "Guardar Producto")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Producto guardado",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Category.class))}),
            @ApiResponse(responseCode = "400", description = "Producto invalido", content = @Content),
            @ApiResponse(responseCode = "401", description = "No tiene autorizacion", content = @Content),
            @ApiResponse(responseCode = "403", description = "Prohibido", content = @Content),
            @ApiResponse(responseCode = "404", description = "Producto no guardado", content = @Content)
    })//swagger
    @PostMapping("/products")// save producto
    public ResponseEntity<ProductResponseRest> save(@RequestParam("picture") MultipartFile picture, @RequestParam("name") String name, @RequestParam("price") int price, @RequestParam("account") int account, @RequestParam("categoryId") Long categoryID) throws IOException {
        Product product = new Product();
        product.setName(name);
        product.setAccount(account);
        product.setPrice(price);
        product.setPicture(Util.compressZLib(picture.getBytes()));//compresion de foto

        ResponseEntity<ProductResponseRest> response = productService.save(product, categoryID);
        return response;
    }

    //swagger
    @Operation(summary = "Buscar producto por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Producto encontrado",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Category.class))}),
            @ApiResponse(responseCode = "400", description = "Producto invalido", content = @Content),
            @ApiResponse(responseCode = "401", description = "No tiene autorizacion", content = @Content),
            @ApiResponse(responseCode = "403", description = "Prohibido", content = @Content),
            @ApiResponse(responseCode = "404", description = "Producto no encontrado", content = @Content)
    })//swagger
    @GetMapping("/products/{id}")//search by id
    public ResponseEntity<ProductResponseRest> searchById(@PathVariable Long id) {
        ResponseEntity<ProductResponseRest> response = productService.searchById(id);
        return response;
    }

    //swagger
    @Operation(summary = "Buscar producto por nombre")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Producto encontrado",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Category.class))}),
            @ApiResponse(responseCode = "400", description = "Producto invalido", content = @Content),
            @ApiResponse(responseCode = "401", description = "No tiene autorizacion", content = @Content),
            @ApiResponse(responseCode = "403", description = "Prohibido", content = @Content),
            @ApiResponse(responseCode = "404", description = "Producto no encontrado", content = @Content)
    })//swagger
    @GetMapping("/products/filter/{name}")//search by name
    public ResponseEntity<ProductResponseRest> searchByName(@PathVariable String name) {
        ResponseEntity<ProductResponseRest> response = productService.searchByName(name);
        return response;
    }

    //swagger
    @Operation(summary = "Eliminar Producto")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Producto eliminado",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Category.class))}),
            @ApiResponse(responseCode = "400", description = "Producto invalido", content = @Content),
            @ApiResponse(responseCode = "401", description = "No tiene autorizacion", content = @Content),
            @ApiResponse(responseCode = "403", description = "Prohibido", content = @Content),
            @ApiResponse(responseCode = "404", description = "Producto no eliminado", content = @Content)
    })//swagger
    @DeleteMapping("/products/{id}")//delete by id
    public ResponseEntity<ProductResponseRest> deleteById(@PathVariable Long id) {
        ResponseEntity<ProductResponseRest> response = productService.deleteById(id);
        return response;
    }

    //swagger
    @Operation(summary = "Obtener Productos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Productos encontrados",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Category.class))}),
            @ApiResponse(responseCode = "400", description = "Productos invalidos", content = @Content),
            @ApiResponse(responseCode = "401", description = "No tiene autorizacion", content = @Content),
            @ApiResponse(responseCode = "403", description = "Prohibido", content = @Content),
            @ApiResponse(responseCode = "404", description = "Productos no encontrados", content = @Content)
    })//swagger
    @GetMapping("/products")//search all
    public ResponseEntity<ProductResponseRest> search() {
        ResponseEntity<ProductResponseRest> response = productService.search();
        return response;
    }

    //swagger
    @Operation(summary = "Actualizar Producto")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Producto actualizado",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Category.class))}),
            @ApiResponse(responseCode = "400", description = "Producto invalido", content = @Content),
            @ApiResponse(responseCode = "401", description = "No tiene autorizacion", content = @Content),
            @ApiResponse(responseCode = "403", description = "Prohibido", content = @Content),
            @ApiResponse(responseCode = "404", description = "Producto no actualizado", content = @Content)
    })//swagger
    @PutMapping("/products/{id}")//update product
    public ResponseEntity<ProductResponseRest> update(@RequestParam("picture") MultipartFile picture,
                                                      @RequestParam("name") String name,
                                                      @RequestParam("price") int price,
                                                      @RequestParam("account") int account,
                                                      @RequestParam("categoryId") Long categoryID,
                                                      @PathVariable Long id) throws IOException {

        Product product = new Product();
        product.setName(name);
        product.setAccount(account);
        product.setPrice(price);
        product.setPicture(Util.compressZLib(picture.getBytes()));

        ResponseEntity<ProductResponseRest> response = productService.update(product, categoryID, id);
        return response;
    }
}
