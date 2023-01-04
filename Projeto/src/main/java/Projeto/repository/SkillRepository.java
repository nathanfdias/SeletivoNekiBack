package Projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Projeto.model.Skill;

public interface SkillRepository extends JpaRepository <Skill, Integer>{
    
}
