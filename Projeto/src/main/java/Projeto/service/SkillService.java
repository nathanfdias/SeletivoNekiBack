package Projeto.service;

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

    public List<Skill> findAll(){
        return skillRepository.findAll();
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
