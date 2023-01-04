package Projeto.security;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

public class JWTValidarFilter extends BasicAuthenticationFilter {

  public static final String HEADER_ATIBUTO = "Authorization";
  public static final String ATIBUTO_PREFIXO = "Bearer ";

  public JWTValidarFilter(AuthenticationManager authenticationManager) {
    super(authenticationManager);
  }

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
      throws IOException, ServletException {

    String atributo = request.getHeader(HEADER_ATIBUTO);

    if (atributo == null) {
      chain.doFilter(request, response);
      return;
    }

    if (!atributo.startsWith(ATIBUTO_PREFIXO)) {
      chain.doFilter(request, response);
      return;
    }

    String token = atributo.replace(ATIBUTO_PREFIXO, "");

    UsernamePasswordAuthenticationToken authenticationToken = getAuthenticationToken(token);

    SecurityContextHolder.getContext().setAuthentication(authenticationToken);
    chain.doFilter(request, response);
  }

  private UsernamePasswordAuthenticationToken getAuthenticationToken(String token) {
    String user = JWT.require(Algorithm.HMAC512(JWTAutenticarFilter.TOKEN_SENHA)).build().verify(token).getSubject();

    if (user == null) {
      return null;
    }

    return new UsernamePasswordAuthenticationToken(user, null, new ArrayList<>());
  }

}
