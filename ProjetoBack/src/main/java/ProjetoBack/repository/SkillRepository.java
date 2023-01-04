package ProjetoBack.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ProjetoBack.model.Skill;

public interface SkillRepository extends JpaRepository<Skill, Long>{
    
}
