package Projeto.dto;

import java.time.LocalDate;

import Projeto.model.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserDTO {

    private Integer id;

    private String username;

    private String password;

    private LocalDate lastLoginDate;

    public UserDTO(User user){
        this.id = user.getId();
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.lastLoginDate = user.getLastLoginDate();
    }
}
