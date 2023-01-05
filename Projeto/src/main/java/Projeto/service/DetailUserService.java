package Projeto.service;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import Projeto.Data.DetailUserData;
import Projeto.model.User;
import Projeto.repository.UserRepository;

@Component
public class DetailUserService implements UserDetailsService{
    private final UserRepository userRepository;

    public DetailUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUsername(username);
        if (user.isEmpty()) {
        throw new UsernameNotFoundException("Username " + username + "não encontrado");
        }

        User u = new User();
        u.setId(user.get().getId());
        u.setUsername(user.get().getUsername());
        u.setPassword(user.get().getPassword());
        u.setLastLoginDate(LocalDate.now());
        userRepository.save(u);

        return new DetailUserData(user);
    }
}
