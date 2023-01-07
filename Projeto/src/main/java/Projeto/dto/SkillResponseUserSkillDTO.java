package Projeto.dto;

import Projeto.model.Skill;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class SkillResponseUserSkillDTO {
    private Integer id;

    private String name;
  
    private String version;
  
    private String description;
  
    private String imgUrl;
  
    public SkillResponseUserSkillDTO (Skill s) {
      this.id = s.getId();
      this.name = s.getName();
      this.version = s.getVersion();
      this.description = s.getDescription();
      this.imgUrl = s.getImage_url();
    }
}
