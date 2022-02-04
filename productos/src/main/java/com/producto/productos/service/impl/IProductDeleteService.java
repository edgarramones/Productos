package com.producto.productos.service.impl;

import com.producto.exception.ProductException;
import com.producto.productos.entity.Product;

public interface IProductDeleteService {
    public  Product deleteProduct(Long id)throws ProductException;

}
