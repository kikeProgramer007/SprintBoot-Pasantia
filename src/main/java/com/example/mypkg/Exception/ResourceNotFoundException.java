package com.example.mypkg.Exception;
/**
 * Excepción personalizada que se utiliza para indicar que un recurso no fue encontrado.
 * Esta clase extiende `RuntimeException` y se usa para manejar errores específicos de recursos no encontrados.
 */
public class ResourceNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 11L;  // Agrega un serialVersionUID
	
    /**
     * Constructor que inicializa la excepción con un mensaje personalizado.
     * @param message Mensaje que describe el error específico.
     */
    public ResourceNotFoundException(String message) {
        super(message); // Llama al constructor de la clase base `RuntimeException` con el mensaje proporcionado.
    }
}