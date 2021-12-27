package com.fnkaya.authservice.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fnkaya.authservice.security.model.LoginInput;
import com.fnkaya.authservice.service.domain.Account;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.io.IOException;
import java.util.Date;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Slf4j
public class AuthTokenFilter extends UsernamePasswordAuthenticationFilter {

    private final UserDetailsService userDetailsService;

    public AuthTokenFilter(UserDetailsService userDetailsService, AuthenticationManager authenticationManager) {
        this.userDetailsService = userDetailsService;
        super.setAuthenticationManager(authenticationManager);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        try {
            LoginInput creds = new ObjectMapper().readValue(request.getInputStream(), LoginInput.class);
            return getAuthenticationManager().authenticate(new UsernamePasswordAuthenticationToken(creds.getEmail(), creds.getPassword()));
        } catch (IOException ex) {
            log.error(ex.getMessage());
            throw new AuthenticationCredentialsNotFoundException(ex.getMessage(), ex);
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult)
        throws IOException, ServletException {
        String username = ((Account) authResult.getPrincipal()).getUsername();
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        String token = Jwts.builder()
            .setSubject(userDetails.getUsername())
            .setExpiration(new Date(System.currentTimeMillis() + 7 * 24 * 60 * 60 * 1000))
            .signWith(SignatureAlgorithm.HS512, "secret_token")
            .compact();
        response.addHeader("token", token);
    }
}
