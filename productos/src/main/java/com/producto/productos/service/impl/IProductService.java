package com.producto.productos.service.impl;

import com.producto.exception.ProductException;
import com.producto.productos.entity.Product;

public interface IProductService {
    /**
     * Utilizado para obtener el status al que está asociado el servicio.
     *
     * @return El status.
     */
	
	public Product createProduct(Product product) throws ProductException;
    public String getStatus();
}
