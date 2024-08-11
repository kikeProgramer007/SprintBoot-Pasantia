package com.example.mypkg.DTO;

import jakarta.validation.constraints.*;
import lombok.Data;
/**
 * Data Transfer Object (DTO) para representar un post en el sistema.
 * Esta clase se utiliza para transferir datos entre diferentes capas de la aplicación.
 */
@Data
public class PostDTO {
	@Min(value = 1, message = "El ID debe ser un número positivo")
	private Integer id;
	
	@NotNull(message = "El ID de usuario no puede ser nulo")
	@Min(value = 1, message = "El ID de usuario debe ser un número positivo")
    private Integer userId;
    
    @NotNull(message = "El título no puede ser nulo")
    @Size(min = 3, max = 100, message = "El título debe tener entre 3 y 100 caracteres")
    private String title;
    
    @Size(max = 500, message = "El cuerpo no puede tener más de 500 caracteres")
    private String body;
}
