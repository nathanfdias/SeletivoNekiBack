package Projeto.dto;

import Projeto.model.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserInsertDTO {

    private String username;

    private String password;

    public UserInsertDTO(User user){
        this.username = user.getUsername();
        this.password = user.getPassword();
    }
}