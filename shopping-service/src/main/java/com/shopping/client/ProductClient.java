package com.shopping.client;


import com.shopping.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "productos-service")
//@RequestMapping(value = "")
public interface ProductClient {

    @GetMapping(value = "/products/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable("id") Long id);

    @GetMapping(value = "/products/{id}/stock")
    public ResponseEntity<Product> updateStockProduct(@PathVariable  Long id ,@RequestParam(name = "quantity", required = true) Double quantity);
    }
