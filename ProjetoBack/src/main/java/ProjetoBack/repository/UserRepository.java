package ProjetoBack.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ProjetoBack.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
    User findByLogin(String login);
}