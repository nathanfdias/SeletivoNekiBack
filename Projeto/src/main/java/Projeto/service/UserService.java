package Projeto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Projeto.model.User;
import Projeto.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    
    public User cadastrarUser(User user){
        User usr =  new User();

        usr.setLogin(user.getLogin());
        usr.setPassword(user.getPassword());
        usr.setLastLoginDate(user.getLastLoginDate());

        return userRepository.save(user);
    }
}
