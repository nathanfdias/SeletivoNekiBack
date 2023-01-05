package Projeto.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Projeto.dto.UserDTO;
import Projeto.model.User;
import Projeto.model.UserSkill;
import Projeto.repository.SkillRepository;
import Projeto.repository.UserRepository;
import Projeto.repository.UserSkillRepository;

@Service
public class UserSkillService {
    
    @Autowired
    private UserSkillRepository userSkillRepository;

    @Autowired
    private SkillRepository skillRepository;

    @Autowired
    private UserRepository userRepository;

    // public UserSkill cadastrar(UserSkill userSkill) {
        
    //     Optional<User> usr = userRepository.findById(UserDTO.getUser().getId());
    // }
}
