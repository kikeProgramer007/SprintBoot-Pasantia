package com.example.mypkg.Service;

import com.example.mypkg.DTO.UserDTO;
import com.example.mypkg.Exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import lombok.RequiredArgsConstructor;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    @Value("${spring.external.service.base-url}")
    private String basePath;
    
	private final RestTemplate restTemplate;
	 
    public List<UserDTO> getUsers(){
        UserDTO[] response = restTemplate.getForObject(basePath+"/users", UserDTO[].class);
        return Arrays.asList(response);
    }
    
    public UserDTO getUserById(Integer id) {
        try {
            return restTemplate.getForObject(basePath + "/users/" + id, UserDTO.class);
        } catch (HttpClientErrorException.NotFound e) {
            throw new ResourceNotFoundException("No se encontró el user con ID: " + id);
        }
    }
    
    public UserDTO saveUser(UserDTO user){
    	return restTemplate.postForObject(basePath+"/users", user, UserDTO.class);
    }

    public void updateUser(Integer id, UserDTO user){
    	restTemplate.put(basePath+"/users/"+id, user);
    }

    public void deleteUser(Integer id){
        restTemplate.delete(basePath+"/users/"+id);
    }
}
