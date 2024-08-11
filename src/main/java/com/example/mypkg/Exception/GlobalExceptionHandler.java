package com.example.mypkg.Exception;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.bind.MethodArgumentNotValidException;

//Clase que maneja globalmente las excepciones en la aplicación.
@ControllerAdvice
public class GlobalExceptionHandler {
	
	// Maneja excepciones de tipo ResourceNotFoundException.
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleResourceNotFoundException(ResourceNotFoundException ex) {
        ErrorResponse errorResponse = new ErrorResponse(
            HttpStatus.NOT_FOUND.value(),
            "Recurso no encontrado",
            ex.getMessage()
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
    // Maneja excepciones de tipo HttpClientErrorException (errores de cliente HTTP).
    @ExceptionHandler(HttpClientErrorException.class)
    public ResponseEntity<ErrorResponse> handleHttpClientErrorException(HttpClientErrorException ex) {
        ErrorResponse errorResponse = new ErrorResponse(
            ex.getStatusCode().value(),
            "Error en la solicitud al servicio externo",
            ex.getMessage()
        );
        return new ResponseEntity<>(errorResponse, ex.getStatusCode());
    }
    // Maneja excepciones generales (captura cualquier excepción no manejada previamente).
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGeneralException(Exception ex) {
        ErrorResponse errorResponse = new ErrorResponse(
            HttpStatus.INTERNAL_SERVER_ERROR.value(),
            "Ocurrió un error inesperado",
            ex.getMessage() // Mensaje específico de la excepción
        );
        // Retorna la respuesta de error con estado 500.
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    
    // Maneja excepciones de validación (captura errores de validación).
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationExceptions(MethodArgumentNotValidException ex) {
        // Recorre los errores de campo y concatena los mensajes de error
        StringBuilder errorMessages = new StringBuilder();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String errorMessage = error.getDefaultMessage();
            errorMessages.append(errorMessage).append("; ");
        });

        // Crea un objeto ErrorResponse con el estado 400 y los mensajes de error
        ErrorResponse errorResponse = new ErrorResponse(
            HttpStatus.BAD_REQUEST.value(),
            "Error de validación",
            errorMessages.toString().trim()
        );

        // Retorna la respuesta de error con estado 400 Bad Request.
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}