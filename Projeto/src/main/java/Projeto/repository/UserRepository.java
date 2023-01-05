package Projeto.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import Projeto.model.User;

public interface UserRepository extends JpaRepository <User, Integer>{
    Optional<User>findByUsername(String username);
    Optional<User>findById(String id);
}
