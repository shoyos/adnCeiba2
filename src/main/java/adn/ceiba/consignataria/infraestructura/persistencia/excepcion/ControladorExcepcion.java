package adn.ceiba.consignataria.infraestructura.persistencia.excepcion;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import adn.ceiba.consignataria.dominio.excepcion.AsesoriaVentasExcepcionFechaInvalida;
import adn.ceiba.consignataria.dominio.excepcion.AutomovilExcepcionBadRequest;

@ControllerAdvice
public class ControladorExcepcion extends ResponseEntityExceptionHandler {
	
    @ExceptionHandler(AutomovilExcepcionBadRequest.class)
    public ResponseEntity<Object> handleAutomovilBadRequest(
    		AutomovilExcepcionBadRequest ex, WebRequest request) {

        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("message", "Error en párametros : "+ex.getMessage());

        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }
    
    @ExceptionHandler(AsesoriaVentasExcepcionFechaInvalida.class)
    public ResponseEntity<Object> handleAsesoriasFechaInvalida(
    		AsesoriaVentasExcepcionFechaInvalida ex, WebRequest request) {

        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("message", "Error en párametros : "+ex.getMessage());

        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }
}
