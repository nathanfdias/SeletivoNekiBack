package ProjetoBack.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import ProjetoBack.exceptions.LoginException;
import ProjetoBack.model.User;
import ProjetoBack.repository.UserRepository;

@Service
public class UserService {
    
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll(){
        List<User> users = userRepository.findAll();

        return users;
    }

    public Optional<User> findById(Long id) {
        
        return userRepository.findById(id);
    }

    public User cadastrarUser(User user){
        User usr =  new User();

        usr.setLogin(user.getLogin());
        usr.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        usr.setLastLoginDate(user.getLastLoginDate());

        return userRepository.save(user);
    }

    @Transactional
    public User loginApp(String login, String password) {
        User users = userRepository.findByLogin(login);

        if (userRepository.findByLogin(login) != null) {

            if (bCryptPasswordEncoder.matches(password, users.getPassword())) {

               User loginOn = new User();
                loginOn.setId(users.getId());
                loginOn.setLogin(users.getLogin());

                return loginOn;
            }
        }

        throw new LoginException("Senha e(ou) email inválidos");
    }
}
