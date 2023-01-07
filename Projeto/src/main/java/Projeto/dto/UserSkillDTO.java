package Projeto.dto;

import java.util.Date;

import Projeto.model.UserSkill;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserSkillDTO {

  private Integer id;
  private UserDTO user;
  private SkillDTO skill;
  private Integer knowledgeLevel;
  private Date createdAt;
  private Date updatedAt;

  public UserSkillDTO(UserSkill userSkill) {
    this.id = userSkill.getId();
    this.user = new UserDTO(userSkill.getUser());
    this.skill = new SkillDTO(userSkill.getSkill());
    this.knowledgeLevel = userSkill.getKnowledgeLevel();
  }
}
