package com.producto.productos.controller;


import com.producto.exception.ProductException;
import com.producto.productos.entity.*;
import com.producto.productos.entity.Product;
import com.producto.productos.service.impl.IProductService;
import com.producto.productos.service.impl.StatusDynamicAutoWireService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping (value = "/products")
public class ProductController {

    @Autowired
    private IProductService productService ;
	
    @Autowired
    private StatusDynamicAutoWireService statusDynamicAutoWireService;

  /*  @GetMapping
    public ResponseEntity<List<Product>> listProduct(@RequestParam(name = "categoryId", required = false) Long categoryId) throws ProductException{
        List<Product> products = new ArrayList<>();
        if (null ==  categoryId){
             products = productService.listAllProduct();
            if (products.isEmpty()){
                return ResponseEntity.noContent().build();
            }
        }else{
            products = productService.findByCategory(Category.builder().id(categoryId).build());
            if (products.isEmpty()){
                return ResponseEntity.notFound().build();
            }
        }


        return ResponseEntity.ok(products);
    }*/


  /*  @GetMapping(value = "/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable("id") Long id) {
        Product product =  productService.getProduct(id);
        if (null==product){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(product);
    }*/

    @PostMapping
    public ResponseEntity<Product> createProduct( @RequestBody Product product) throws ProductException{      
        IProductService productService =
                this.statusDynamicAutoWireService.getServiceMap().get(product.getStatus());
        return new ResponseEntity<>(productService.createProduct(product),
                HttpStatus.CREATED);
    }
    /*
   @PutMapping(value = "/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable("id") Long id, @RequestBody Product product) throws ProductException{
        product.setId(id);
        Product productDB =  productService.updateProduct(product);
        if (productDB == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(productDB);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Product> deleteProduct(@PathVariable("id") Long id) throws ProductException{
        Product productDelete = productService.deleteProduct(id);
        if (productDelete == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(productDelete);
    }
    @PutMapping (value = "/{id}/stock")
    public ResponseEntity<Product> updateStockProduct(@PathVariable  Long id ,@RequestParam(name = "quantity", required = true) Double quantity) throws ProductException{
        Product product = productService.updateStock(id, quantity);
        if (product == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(product);
    }*/
    private String formatMessage( BindingResult result){
        List<Map<String,String>> errors = result.getFieldErrors().stream()
                .map(err ->{
                    Map<String,String>  error =  new HashMap<>();
                    error.put(err.getField(), err.getDefaultMessage());
                    return error;

                }).collect(Collectors.toList());
        ErrorMessage errorMessage = ErrorMessage.builder()
                .code("01")
                .messages(errors).build();
        ObjectMapper mapper = new ObjectMapper();
        String jsonString="";
        try {
            jsonString = mapper.writeValueAsString(errorMessage);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return jsonString;
    }
}
