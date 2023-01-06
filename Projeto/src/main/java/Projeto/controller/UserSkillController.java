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

import Projeto.dto.UserSkillDTO;
import Projeto.model.UserSkill;
import Projeto.service.UserSkillService;

@RestController
@RequestMapping("/userskill")
public class UserSkillController {
  @Autowired
  public UserSkillService userSkillService;

  @PostMapping("/cadastrar")
  public ResponseEntity<Object> cadastrar(@Valid @RequestBody UserSkill userSkill) {
    userSkillService.cadastrarUserSkill(userSkill);
    URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(userSkill.getId()).toUri();
    return ResponseEntity.created(uri).body(userSkill);
  }

  @GetMapping
  public ResponseEntity<List<UserSkillDTO>> listar() {
    return ResponseEntity.ok(userSkillService.findAll());
  }

  @PutMapping("{id}")
  public ResponseEntity<UserSkillDTO> atualizar(@PathVariable Integer id, @Valid @RequestBody UserSkill userSkill) {
    UserSkillDTO userSkillDTO = userSkillService.atualizar(id, userSkill);
    if (userSkillDTO != null) {
      URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
          .buildAndExpand(userSkillDTO.getId())
          .toUri();
      return ResponseEntity.created(uri).body(userSkillDTO);
    }

    return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
  }

  @DeleteMapping("{id}")
  public ResponseEntity<?> deletar(@PathVariable Integer id) {

    Boolean response = userSkillService.delete(id);
    System.out.println(response);
    if (response != true) {
      return ResponseEntity.notFound().build();
    }

    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

  }

}
