package com.producto.productos.service.impl;


import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.producto.constant.StatusConstants;
import com.producto.exception.ProductException;
import com.producto.productos.entity.Product;
import com.producto.productos.repository.ProductRepository;

/**
 *
 * @author eramones
 */
@Service(StatusConstants.STATUS_CREATE_NOMBRE)
public class ProductCreateService implements IProductService {

    private static final Logger logger =
            LoggerFactory.getLogger(ProductCreateService.class);

    @Autowired
    private  ProductRepository productRepository;
    @Override
    public Product createProduct(Product product) throws ProductException {
        if (product.getStatus() != null) {
            
                throw ProductException.ESTATUS_REQUERIDO;
            }
        product.setCreateAt(new Date());

        return productRepository.save(product);
    }
    /**
     * {@inheritDoc}
     */
	@Override
	public String getStatus() {
		return StatusConstants.STATUS_CREATE_NOMBRE;
	}




}
