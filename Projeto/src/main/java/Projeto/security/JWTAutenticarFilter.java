package Projeto.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.util.UrlPathHelper;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;

import Projeto.Data.DetailUserData;
import Projeto.dto.LoginResponseDTO;
import Projeto.model.User;

    public class JWTAutenticarFilter extends UsernamePasswordAuthenticationFilter {

    public static final int TOKEN_EXPIRACAO = 3600000;

    public static final String TOKEN_SENHA = "b7af8249-3550-4a62-93c5-0b5620ef4888";

    private final AuthenticationManager authenticationManager;

    private final static UrlPathHelper urlPathHelper = new UrlPathHelper();

    public JWTAutenticarFilter(AuthenticationManager authenticationManager) {
      this.authenticationManager = authenticationManager;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
        throws AuthenticationException {
      try {
        User user = new ObjectMapper().readValue(request.getInputStream(), User.class);

        return authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword(), new ArrayList<>()));
      } catch (IOException e) {
        throw new RuntimeException("Falha ao authenticar usuario", e);
      }
      
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
        Authentication authResult) throws IOException, ServletException {

      DetailUserData usarioData = (DetailUserData) authResult.getPrincipal();

      String token = JWT.create().withSubject(usarioData.getUsername())
          .withExpiresAt(new Date(System.currentTimeMillis() + TOKEN_EXPIRACAO)).sign(Algorithm.HMAC512(TOKEN_SENHA));

      response.getWriter().write(new ObjectMapper()
          .writeValueAsString(new LoginResponseDTO(token, usarioData.getUsername(), usarioData.getId())));
      response.getWriter().flush();
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response,
        AuthenticationException failed) throws IOException, ServletException {

      logger.debug("failed authentication while attempting to access "
          + urlPathHelper.getPathWithinApplication((HttpServletRequest) request));

      response.setStatus(401);
      response.getWriter().write("Authentication Failed");
      response.getWriter().flush();
    }

}
