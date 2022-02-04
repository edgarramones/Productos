package com.producto.productos.service.impl;

import java.util.List;

import com.producto.exception.ProductException;
import com.producto.productos.entity.Category;
import com.producto.productos.entity.Product;

public interface IproductCategoryService {
    public List<Product> findByCategory(Category category)throws ProductException;

}
