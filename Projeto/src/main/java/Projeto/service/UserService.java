package Projeto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import Projeto.model.User;
import Projeto.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    
    public User cadastrarUser(User u){

        User user = new User();
        user.setUsername(u.getUsername());
        user.setPassword(bCryptPasswordEncoder.encode(u.getPassword()));
        user.setLastLoginDate(null);
        user = userRepository.save(user);

        return user;
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }
}
