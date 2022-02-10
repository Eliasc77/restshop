package com.example.demo.security.jwt;

import com.example.demo.modelo.Usuario;

public class JwtResponse{


	private  Usuario user;
	private  String jwttoken;
	
	
	
	public JwtResponse(Usuario user, String jwttoken) {
		super();
		this.user = user;
		this.jwttoken = jwttoken;
	}
	public Usuario getUser() {
		return user;
	}
	public String getJwttoken() {
		return jwttoken;
	}
	
	public void setUser(Usuario user) {
		this.user = user;
	}
	public void setJwttoken(String jwttoken) {
		this.jwttoken = jwttoken;
	}
	
	
	

	
	

}
