package com.example.themaplreable.controller;

import com.example.themaplreable.dto.ProductDto;
import com.example.themaplreable.exception.ProductNotFoundException;
import com.example.themaplreable.exception.TypeNotExistException;
import com.example.themaplreable.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Products Controller.
 */
@Controller
@RequestMapping("/products")
public class ProductsController {
    private final ProductsService productService;


    @Autowired
    public ProductsController(ProductsService productService) {
        this.productService = productService;
    }

    /**
     * Get all catalogue's product (with optional filter : type)
     *
     * @param type type
     * @return ResponseEntity<List<ProductDto>>
     */
    @GetMapping(value = {"/", "/{type}"})
    public ResponseEntity<List<ProductDto>> getCatalogue(@PathVariable(name = "type", required = false) Optional<String> type, Model model) throws TypeNotExistException {
      /*  List<ProductDto> productList = productService.getCatalogue(type);
        model.addAttribute("productList", productList);
        return "maplrErableHome";*/

        return ResponseEntity.ok().body(productService.getCatalogue(type));
    }

    /**
     * Get one product by productId
     *
     * @param productId productId
     * @return ResponseEntity<ProductDto>
     */
    @GetMapping("/{productId}")
    public ResponseEntity<ProductDto> getProductInfo(@PathVariable String productId) throws ProductNotFoundException {
        return ResponseEntity.ok().body(productService.getProductInfo(productId));
    }
}
