package Projeto.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

// import lombok.Data;


@Entity
@Table(name = "user")
public class User {
    
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="user_sequence")
    @SequenceGenerator(name="user_sequence", sequenceName="user_seq")
    private Long id;

    @Column( name = "login" )
    private String login;

    @Column( name = "password")
    private String password;

    @Column( name = "last_login_date")
    private LocalDate lastLoginDate;

    @OneToMany ( mappedBy = "user")
    private List<UserSkill> userSkill;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setLastLoginDate(LocalDate lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    public void setUserSkill(List<UserSkill> userSkill) {
        this.userSkill = userSkill;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public LocalDate getLastLoginDate() {
        return lastLoginDate;
    }

    public List<UserSkill> getUserSkill() {
        return userSkill;
    }
}
