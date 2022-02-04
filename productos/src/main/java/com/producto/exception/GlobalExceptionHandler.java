package com.producto.exception;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.productos.model.error.ModelError;

import javax.servlet.http.HttpServletResponse;


/**
 * @author eramones
 */
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    private static final Logger LOG =
            LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler({ProductException.class})
    public ResponseEntity<ModelError> handleBusinessException(HttpServletResponse respuesta,
                                                              Exception excepcion) {
        BaseException baseException = (BaseException) excepcion;
        respuesta.setStatus(baseException.getStatus().value());
        return new ResponseEntity<>(
                new ModelError(baseException.getId(),
                        baseException.getEstado(),
                        baseException.getDescripcion()),
                baseException.getStatus());

    }

    @Override
    public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                               HttpHeaders headers, HttpStatus status, WebRequest request) {
        return new ResponseEntity<>(
                new ModelError(BaseException.LABEL_ERROR_ID, BaseException.GENERIC_CODE_ERROR,
                        ex.getMessage()),
                HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<ModelError> handleAllUncaughtException(
            Exception exception) {
        LOG.error("Unknown error occurred", exception);
        return new ResponseEntity<>(
                new ModelError(BaseException.LABEL_ERROR_ID, BaseException.GENERIC_CODE_ERROR,
                        "Error desconocido. Por favor, notifique al " +
                                "administrador"),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
