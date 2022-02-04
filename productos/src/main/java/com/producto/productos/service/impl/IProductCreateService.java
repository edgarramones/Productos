package com.producto.productos.service.impl;

import com.producto.exception.ProductException;
import com.producto.productos.entity.Product;

public interface IProductCreateService {
    public Product createProduct(Product product) throws ProductException;

}
