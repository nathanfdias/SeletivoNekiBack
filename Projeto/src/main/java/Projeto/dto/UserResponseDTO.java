package Projeto.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import Projeto.model.User;
import Projeto.model.UserSkill;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class UserResponseDTO {

  private Integer id;

  private String username;

  private LocalDate lastLoginDate;

  private List<UserSkillResponseUserDTO> userSkill;

  public UserResponseDTO(User u) {
    this.id = u.getId();
    this.username = u.getUsername();
    this.lastLoginDate = u.getLastLoginDate();

    List<UserSkillResponseUserDTO> userSkillDTO = new ArrayList<>();
    for (UserSkill skill : u.getUserSkill()) {
      userSkillDTO.add(new UserSkillResponseUserDTO(skill));
    }
    this.userSkill = userSkillDTO;
  }
}
