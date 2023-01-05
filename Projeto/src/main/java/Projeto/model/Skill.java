package Projeto.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "skill")
public class Skill {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="skill_sequence")
    @SequenceGenerator(name="skill_sequence", sequenceName="skill_seq", allocationSize = 1)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "version")
    private String version;

    @Column(name = "description", length = 300)
    private String description;

    @Column(name = "image_url")
    private String image_url;

    @OneToOne ( mappedBy = "skill")
    private UserSkill userSkill;
}

