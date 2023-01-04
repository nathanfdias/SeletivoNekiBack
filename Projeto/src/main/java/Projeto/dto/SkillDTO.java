package Projeto.dto;

import Projeto.model.Skill;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SkillDTO {

    private Integer id;

    private String name;

    private String version;

    private String description;

    private String image_url;

    public SkillDTO(Skill skill){
        this.id = skill.getId();
        this.name = skill.getName();
        this.version = skill.getVersion();
        this.description = skill.getDescription();
        this.image_url = skill.getImage_url();
    }

}
