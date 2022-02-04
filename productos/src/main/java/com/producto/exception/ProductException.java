package com.producto.exception;


import org.springframework.http.HttpStatus;

import java.text.DecimalFormat;

/**
 * @author eramones
 */
public class ProductException extends BaseException {

    private static final long serialVersionUID = -3153534737722320490L;



    public ProductException(String descripcion, String estado, HttpStatus status) {
        super(descripcion, estado, status);
    }


    public static final ProductException ESTATUS_REQUERIDO = new ProductException(
            "El Status es Requerido",
            "01", HttpStatus.BAD_REQUEST);

    @Override
    public String toString() {
        return "ProductException{" +
                "id='" + id + '\'' +
                ", estado='" + estado + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", status=" + status +
                '}';
    }
}