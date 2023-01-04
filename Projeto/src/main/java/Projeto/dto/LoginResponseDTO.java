package Projeto.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
@AllArgsConstructor
public class LoginResponseDTO {

  private Integer id;
  private String username;
  private String token;

  public LoginResponseDTO(String tokenBearer, String username, Integer id) {
    this.id = id;
    this.username = username;
    this.token = tokenBearer;
  }
}