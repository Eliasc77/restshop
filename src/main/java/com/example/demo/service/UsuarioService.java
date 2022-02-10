package com.example.demo.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import com.example.demo.modelo.Usuario;

import com.example.demo.modelo.Rol;
import com.example.demo.repository.RolRepository;
import com.example.demo.repository.UsuarioRepository;



@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private RolRepository rolRepo;
	
	
	public UsuarioService() {
		super();
	}

	public void initRoleAndUser() {
		
		Rol admin = new Rol();
		admin.setCodRol("R01");
		admin.setNomRol("Admin");
		admin.setEstado("Rol for admin application");
		rolRepo.save(admin);
		
		Rol user = new Rol();
		user.setCodRol("R02");
		user.setNomRol("User");
		user.setEstado("Default rol for new users");
		rolRepo.save(user);
		
		
		Usuario userAdmin = new Usuario();
		Rol role = rolRepo.findById("R01").get();
		Set<Rol> userRoles = new HashSet<>();
		userRoles.add(role);
		userAdmin.setCodUsu(1);
		userAdmin.setEmail("admin.1@gmail.com");
		userAdmin.setPassword(passwordEncoder.encode("123456"));
		userAdmin.setRol(userRoles);	
		repo.save(userAdmin);
			
	}


	public Collection<Usuario> findAll(){
		return (Collection<Usuario>)repo.findAll();
	}
	
	public Usuario registerNewUser(Usuario user) {
		Rol role = rolRepo.findById("R02").get();
		Set<Rol> userRoles = new HashSet<>();
		userRoles.add(role);
		user.setRol(userRoles);
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return repo.save(user);
	}

	
	public Usuario updateUser (Usuario user) {
		Rol role = rolRepo.findById("R02").get();
		Set<Rol> userRoles = new HashSet<>();
		userRoles.add(role);
		user.setRol(userRoles);
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return repo.save(user);
	}
	
	public Usuario findById(int id) {
		return repo.findById(id).orElse(null);
	}
	
	public void delete(Integer id) {
		repo.deleteById(id);
	}
	

	//iniciar sesion
    public List<Usuario> login (String email, String password){      
        return repo.userLogin(email, password);
    }
    
    
    public List<Usuario> login2(String email, String password){

    	return repo.userLogin(email, password);
    }

	
	
}
