package com.example.themaplreable.controller;

import com.example.themaplreable.dto.ProductDto;
import com.example.themaplreable.exception.ProductNotFoundException;
import com.example.themaplreable.exception.TypeNotExistException;
import com.example.themaplreable.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Products Controller.
 */
@Controller()
@RequestMapping(
        value = "/product",
        produces = "application/json",
        method = {RequestMethod.GET, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.PATCH})
public class ProductController {
    private final ProductService productsService;


    /**
     * Constructor
     */
    @Autowired
    public ProductController(ProductService productsService) {
        this.productsService = productsService;
    }

    /**
     * Get all catalogue's product (with optional filter : type)
     *
     * @param type type
     * @return List<ProductDto>
     */
    @GetMapping(value = {"/all", "/all/{type}"})
    public String getCatalogue(@PathVariable(name="type", required = false) String type, Model model) throws TypeNotExistException {
        List<ProductDto> productList = productsService.getCatalogue(type);
        model.addAttribute("productList", productList);
        return "maplrErableHome";
    }

    /**
     * Get one product by productId
     *
     * @param productId productId
     * @return ProductDto
     */
    @GetMapping("/{productId}")
    public ResponseEntity<ProductDto> getProductInfo(@PathVariable String productId) throws ProductNotFoundException {
        return ResponseEntity.ok().body(productsService.getProductInfo(productId));
    }
}
