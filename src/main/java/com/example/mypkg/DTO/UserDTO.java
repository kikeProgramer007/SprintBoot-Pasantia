package com.example.mypkg.DTO;
import lombok.Data;
import jakarta.validation.constraints.*;

/**
 * Data Transfer Object (DTO) para representar un post en el sistema.
 * Esta clase se utiliza para transferir datos entre diferentes capas de la aplicación.
 */
@Data
public class UserDTO {

	private Integer id;
    
    @NotBlank(message = "El nombre no puede estar en blanco")
    @Size(min = 2, max = 50, message = "El nombre debe tener entre 2 y 50 caracteres")
	private String name;
    
    @NotBlank(message = "El nombre de usuario no puede estar en blanco")
    @Size(min = 3, max = 50, message = "El nombre de usuario debe tener entre 3 y 50 caracteres")
	private String username;
    
    @NotBlank(message = "El correo electrónico no puede estar en blanco")
    @Email(message = "El correo electrónico debe tener un formato válido")
	private String email;
    
    @Size(max = 255, message = "La URL del avatar no puede tener más de 400 caracteres")
	private String avatar;	
}
