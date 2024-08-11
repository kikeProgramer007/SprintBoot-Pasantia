package com.example.mypkg.Service;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.example.mypkg.DTO.PostDTO;
import lombok.RequiredArgsConstructor;
import com.example.mypkg.Exception.ResourceNotFoundException;
import org.springframework.web.client.HttpClientErrorException;

import java.util.Arrays;
import java.util.List;

/**
 * Servicio para gestionar las operaciones relacionadas con los posts.
 * Utiliza RestTemplate para comunicarse con un servicio externo.
 */
@Service
@RequiredArgsConstructor
public class PostService {
	
	// Base URL del servicio externo, inyectado desde el archivo de configuración
	@Value("${spring.external.service.base-url}")
	
	// RestTemplate para realizar solicitudes HTTP al servicio externo
	private String basePath;

	private final RestTemplate restTemplate;
	
	//Obtiene una lista de todos los posts desde el servicio externo.
    public List<PostDTO> getPosts() {
        PostDTO[] response = restTemplate.getForObject(basePath + "/posts", PostDTO[].class);
        return Arrays.asList(response);
    }
    //Obtiene un post por su ID desde el servicio externo.
    public PostDTO getPostById(Integer id) {
        try {
            // Realiza una solicitud GET al endpoint /posts/{id} y convierte la respuesta en un PostDTO
            return restTemplate.getForObject(basePath + "/posts/" + id, PostDTO.class);
        } catch (HttpClientErrorException.NotFound e) {
        	 // Lanza una excepción personalizada si el post no es encontrado
            throw new ResourceNotFoundException("No se encontró el post con ID: " + id);
        }
    }
    //Guarda un nuevo post en el servicio externo.
    public PostDTO savePost(PostDTO post) {
        return restTemplate.postForObject(basePath + "/posts", post, PostDTO.class);
    }
    //Actualiza un post existente en el servicio externo.
    public PostDTO updatePost(Integer id, PostDTO post) {
        restTemplate.put(basePath + "/posts/" + id, post);
        return restTemplate.getForObject(basePath + "/posts/" + id, PostDTO.class);
    }
    //Elimina un post del servicio externo.
    public void deletePost(Integer id) {
        restTemplate.delete(basePath + "/posts/" + id);
    }
}
