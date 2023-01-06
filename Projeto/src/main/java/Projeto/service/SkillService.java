package Projeto.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Projeto.dto.SkillDTO;
import Projeto.model.Skill;
import Projeto.repository.SkillRepository;

@Service
public class SkillService {
    @Autowired
    private SkillRepository skillRepository;

    public Skill cadastrarSkill(Skill s){

        Skill skill = new Skill();
        skill.setName(s.getName());
        skill.setDescription(s.getDescription());
        skill.setImage_url(s.getImage_url());
        skill.setVersion(s.getVersion());

        skill = skillRepository.save(skill);

        return skill;
    }

    public List<SkillDTO> findAll(){
        List<Skill> skills = skillRepository.findAll();
        List<SkillDTO> skillDTO = new ArrayList<>();

        for (Skill skill : skills) {
            skillDTO.add(new SkillDTO(skill));
        }
        return skillDTO;
    }

    public SkillDTO atualizar(Integer id, Skill skill){
        skill.setId(id);
        Skill newSkill = new Skill();

        newSkill.setId(skill.getId());
        newSkill.setName(skill.getName());
        newSkill.setVersion(skill.getVersion());
        newSkill.setDescription(skill.getDescription());
        newSkill.setImage_url(skill.getImage_url());
        
        skillRepository.save(newSkill);

        return new SkillDTO(skill);
    }

    public Boolean delete(Integer id){
        Optional<Skill> skill = skillRepository.findById(id);

        if(skill.isPresent()){
            skillRepository.deleteById(id);
            return true;
        }

        return false;
    }


}
