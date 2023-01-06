package Projeto.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import Projeto.dto.UserDTO;
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

    public List<UserDTO> findAll(){
        List<User> users = userRepository.findAll();
        List<UserDTO> userDTO = new ArrayList<>();

        for (User user : users) {
            userDTO.add(new UserDTO(user));
        }
        return userDTO;
    }

    public UserDTO atualizar(Integer id, User user){
        user.setId(id);
        User newUser = new User();

        newUser.setId(user.getId());
        newUser.setUsername(user.getUsername());
        newUser.setPassword(user.getPassword());
        newUser.setLastLoginDate(user.getLastLoginDate());
        
        userRepository.save(newUser);

        return new UserDTO(user);
    }

    public Boolean delete(Integer id){
        Optional<User> user = userRepository.findById(id);

        if(user.isPresent()){
            userRepository.deleteById(id);
            return true;
        }

        return false;
    }
}
