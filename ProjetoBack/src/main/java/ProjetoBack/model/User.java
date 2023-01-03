package ProjetoBack.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
@Entity
@Table(name= "user")
public class User {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotBlank
    @Column( name = "login" )
    private String login;

    @NotBlank
    @Column( name = "password")
    private String password;

    @Column( name = "last_login_date")
    private LocalDate lastLoginDate;

    @OneToMany ( mappedBy = "user")
    private List<UserSkill> userSkill;

}
