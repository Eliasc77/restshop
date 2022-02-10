package com.example.demo.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import com.example.demo.modelo.Usuario;
import com.example.demo.repository.UsuarioRepository;
import com.example.demo.security.jwt.JwtRequest;
import com.example.demo.security.jwt.JwtResponse;
import com.example.demo.security.jwt.JwtTokenUtil;

@Service
public class JwtService implements UserDetailsService {

	@Autowired
	private UsuarioRepository userrepo;
	
	@Autowired
	private JwtTokenUtil tokenutil;
	
	@Autowired
    private AuthenticationManager authenticationManager;
	
    public JwtResponse createJwtToken(JwtRequest jwtRequest) throws Exception {
        String userName = jwtRequest.getUsername();
        String userPassword = jwtRequest.getPassword();
        authenticate(userName, userPassword);

        UserDetails userDetails = loadUserByUsername(userName);
        String newGeneratedToken = tokenutil.generateToken(userDetails);

        Usuario user = userrepo.findUserByEmail(userName).get();
        return new JwtResponse(user, newGeneratedToken);
    }
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario user =  userrepo.findUserByEmail(username).get();
        if (user != null) {
            return new org.springframework.security.core.userdetails.User(
                    user.getEmail(),
                    user.getPassword(),
                    getAuthority(user)
            );
        } else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
	
	}

	private Set getAuthority(Usuario user) {
		 Set<SimpleGrantedAuthority> authorities = new HashSet<>();
		 user.getRol().forEach(rol ->{
			 authorities.add(new SimpleGrantedAuthority("ROL_" + rol.getNomRol()));
		 });
		return authorities;
	}
	
    private void authenticate(String userName, String userPassword) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userName, userPassword));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
}
