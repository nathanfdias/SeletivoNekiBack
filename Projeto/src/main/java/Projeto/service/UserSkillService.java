package Projeto.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.hibernate.service.spi.OptionallyManageable;
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
        userSkill.setCreatedAt(new Date());
        userSkill.setUpdatedAt(new Date());

        return userSkillRepository.save(userSkill);

    }

    public List<UserSkillDTO> findAll() {
        List<UserSkill> user = userSkillRepository.findAll();
        List<UserSkillDTO> skillDTO = new ArrayList<>();

        for (UserSkill users : user) {
            skillDTO.add(new UserSkillDTO(users));
        }
        return skillDTO;
    }


    public UserSkillDTO atualizar(Integer id, UserSkill userSkill) {
        userSkill.setId(id);
        UserSkill newUser = new UserSkill();
        Optional<UserSkill> userSkillS = userSkillRepository.findById(id);

        newUser.setId(userSkill.getId());
        newUser.setKnowledgeLevel(userSkill.getKnowledgeLevel());
        newUser.setSkill(userSkill.getSkill());
        newUser.setUser(userSkill.getUser());
        newUser.setCreatedAt(userSkillS.get().getCreatedAt());
        newUser.setUpdatedAt(new Date());

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