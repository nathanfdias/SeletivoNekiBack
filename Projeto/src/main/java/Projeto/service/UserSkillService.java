package Projeto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Projeto.dto.UserSkillDTO;
import Projeto.model.Skill;
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

    public UserSkill cadastrarUserSkill(UserSkill u) {

        UserSkill userSkill = new UserSkill();
        User user = userRepository.getReferenceById(u.getUser().getId());
        Skill skill = skillRepository.getReferenceById(u.getSkill().getId());

        userSkill.setId(u.getId());
        userSkill.setKnowledgeLevel(u.getKnowledgeLevel());
        userSkill.setUser(user);
        userSkill.setSkill(skill);

        return userSkillRepository.save(userSkill);

    }

    public List<UserSkill> findAll() {
        return userSkillRepository.findAll();
    }

    public UserSkillDTO atualizar(Integer id, UserSkill userSkill) {
        userSkill.setId(id);
        UserSkill newUser = new UserSkill();

        newUser.setId(userSkill.getId());
        newUser.setKnowledgeLevel(userSkill.getKnowledgeLevel());
        newUser.setSkill(userSkill.getSkill());
        newUser.setUser(userSkill.getUser());

        userSkillRepository.save(newUser);

        return new UserSkillDTO(userSkill);
    }

    public Boolean delete(Integer id) {
        Optional<UserSkill> userSkill = userSkillRepository.findById(id);
        if (userSkill.isPresent()) {
            userSkillRepository.deleteById(id);
            return true;
        }

        return false;
    }
}