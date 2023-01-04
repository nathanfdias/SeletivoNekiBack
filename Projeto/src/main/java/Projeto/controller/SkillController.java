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

import Projeto.dto.SkillDTO;
import Projeto.model.Skill;
import Projeto.service.SkillService;

@RestController
@RequestMapping("/skill")
public class SkillController {
    @Autowired
    public SkillService skillService;


    @PostMapping("/cadastrar")
    public ResponseEntity<Object> cadastrar(@Valid @RequestBody Skill skill){
        skillService.cadastrarSkill(skill);
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(skill.getId()).toUri();
                return ResponseEntity.created(uri).body(skill);
    }

    @GetMapping
    public ResponseEntity<List<Skill>> listar(){
        return ResponseEntity.ok(skillService.findAll());
    }

    @PutMapping("{id}")
	public ResponseEntity<SkillDTO> atualizar(@PathVariable Integer id, @Valid @RequestBody Skill skill) {
		SkillDTO skillDTO = skillService.atualizar(id, skill);		
        if (skillDTO != null) {
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                    .buildAndExpand(skillDTO.getId())
                    .toUri();
            return ResponseEntity.created(uri).body(skillDTO);
        } 
        
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}

    @DeleteMapping("{id}")
    public ResponseEntity<?> deletar(@PathVariable Integer id) {

        Boolean response = skillService.delete(id);
        System.out.println(response);
        if (response != true) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }
}
