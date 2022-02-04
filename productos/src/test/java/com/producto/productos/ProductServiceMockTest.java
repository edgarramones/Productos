package com.producto.productos;


import com.producto.exception.ProductException;
import com.producto.productos.entity.*;
import com.producto.productos.repository.ProductRepository;
import com.producto.productos.service.impl.IProductService;
import com.producto.productos.service.impl.ProductService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class ProductServiceMockTest {

    @Mock
    private ProductRepository productRepository;

    private ProductService productService;

    @BeforeEach
    public void setup(){
        MockitoAnnotations.initMocks(this);
        productService =  new ProductService( productRepository);
        Product computer =  Product.builder()
                .id(1L)
                .name("computer")
                .category(Category.builder().id(1L).build())
                .price(Double.parseDouble("12.5"))
                .stock(Double.parseDouble("5"))
                .build();

        Mockito.when(productRepository.findById(1L))
                .thenReturn(Optional.of(computer));
        Mockito.when(productRepository.save(computer)).thenReturn(computer);

    }

 /*   @Test
   public void whenValidGetID_ThenReturnProduct(){
        Product found = productService.createProduct(1L);
       Assertions.assertThat(found.getName()).isEqualTo("computer");

   }*/

  /* @Test
   public void whenValidUpdateStock_ThenReturnNewStock() throws NumberFormatException, ProductException{
        Product newStock = productService.updateStock(1L,Double.parseDouble("8"));
        Assertions.assertThat(newStock.getStock()).isEqualTo(13);
   }*/
}
