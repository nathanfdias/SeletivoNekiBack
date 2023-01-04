package ProjetoBack.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ProjetoBack.model.UserSkill;

public interface UserSkillRepository extends JpaRepository<UserSkill, Long>{
    
}