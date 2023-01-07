package Projeto.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import Projeto.dto.UserDTO;
import Projeto.dto.UserResponseDTO;
import Projeto.model.User;
import Projeto.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    public UserService userService;


    @PostMapping("/cadastrar")
    public ResponseEntity<Object> cadastrar(@Valid @RequestBody User user){
        userService.cadastrarUser(user);
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
                return ResponseEntity.created(uri).body(user);
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> listar(){
        return ResponseEntity.ok(userService.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<UserResponseDTO> findById(@PathVariable Integer id){
        return ResponseEntity.ok(userService.findById(id));
    }

    @PutMapping("{id}")
	public ResponseEntity<UserDTO> atualizar(@PathVariable Integer id, @Valid @RequestBody User user) {
		UserDTO userDTO = userService.atualizar(id, user);		
        if (userDTO != null) {
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                    .buildAndExpand(userDTO.getId())
                    .toUri();
            return ResponseEntity.created(uri).body(userDTO);
        } 
        
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}

    @DeleteMapping("{id}")
    public ResponseEntity<?> deletar(@PathVariable Integer id) {

        Boolean response = userService.delete(id);
        System.out.println(response);
        if (response != true) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }

}
