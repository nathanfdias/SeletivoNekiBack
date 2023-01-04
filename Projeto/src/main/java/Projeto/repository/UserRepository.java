package Projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Projeto.model.User;

public interface UserRepository extends JpaRepository <User, Long>{

}
