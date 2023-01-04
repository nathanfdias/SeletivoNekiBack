package Projeto.Data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import Projeto.model.User;

public class DetailUserData implements UserDetails{
    
    private final Optional<User> usuario;

  public DetailUserData(Optional<User> usuario) {
    this.usuario = usuario;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return new ArrayList<>();
  }

  public Integer getId() {
    return usuario.orElse(new User()).getId();
  }

  @Override
  public String getPassword() {
    return usuario.orElse(new User()).getPassword();
  }

  @Override
  public String getUsername() {
    return usuario.orElse(new User()).getUsername();
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }
}
