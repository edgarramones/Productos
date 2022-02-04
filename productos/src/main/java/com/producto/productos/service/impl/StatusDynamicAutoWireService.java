package com.producto.productos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Utilizada para obtener de forma dinámica la implementación deseada de la interface {@link IProductService}.
 *
 * @author eramones
 */
@Service
public class StatusDynamicAutoWireService {

    /**
     * Mapa con la lista de implementaciones de la interface {@link IProductService}.
     */
    private final Map<String, IProductService> serviceMap;



    // METODOS

    /**
     * Constructor de la clase.
     *
     * @param ProductServiceList La lista de implementaciones de la interface {@link IProductsService}.
     */
    @Autowired
    public StatusDynamicAutoWireService(List<IProductService> productServiceList) {
        serviceMap = productServiceList.stream()
                .collect(Collectors.toMap(IProductService::getStatus, Function.identity()));
    }



    // GETTERS

    public Map<String, IProductService> getServiceMap() {
        return serviceMap;
    }

}
