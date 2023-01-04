package Projeto.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
    public ResponseEntity<List<User>> listar(){
        return ResponseEntity.ok(userService.findAll());
    }
}
