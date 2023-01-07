package Projeto.dto;

import java.util.Date;

import Projeto.model.UserSkill;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class UserSkillResponseUserDTO {
  
  private Integer id;

  private Integer knowledgeLevel;

  private Date createdAt;

  private Date updatedAt;

  private SkillResponseUserSkillDTO skill;

  public UserSkillResponseUserDTO (UserSkill u) {
    this.id = u.getId();
    this.knowledgeLevel = u.getKnowledgeLevel();
    this.createdAt = u.getCreatedAt();
    this.updatedAt = u.getUpdatedAt();
    this.skill = new SkillResponseUserSkillDTO(u.getSkill());
  }

}