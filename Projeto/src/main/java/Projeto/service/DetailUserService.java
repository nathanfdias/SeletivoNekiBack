package Projeto.service;

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

        return new DetailUserData(user);
    }
}
