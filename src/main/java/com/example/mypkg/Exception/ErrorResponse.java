package com.example.mypkg.Exception;
/**
 * Clase que representa una respuesta de error en la API.
 * Esta clase se utiliza para estructurar la información de error que se envía al cliente.
 */
public class ErrorResponse {
	// Código de estado HTTP asociado al error (ej. 404, 500)
	private int status;
	// Mensaje de error genérico para el cliente
    private String message;
    // Mensaje adicional que proporciona detalles específicos sobre el error
    private String mensajeException;

    public ErrorResponse(int status, String message, String mensajeException) {
        this.status = status;
        this.message = message;
        this.mensajeException = mensajeException;
    }

    // Getters y setters para acceder y modificar los campos de la clase
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMensajeException() {
        return mensajeException;
    }

    public void setMensajeException(String mensajeException) {
        this.mensajeException = mensajeException;
    }
}
