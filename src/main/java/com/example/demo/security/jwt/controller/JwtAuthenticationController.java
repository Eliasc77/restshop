package com.example.demo.security.jwt.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.security.jwt.JwtRequest;
import com.example.demo.security.jwt.JwtResponse;

import com.example.demo.service.JwtService;






@RestController
@CrossOrigin
public class JwtAuthenticationController {

	@Autowired
	private JwtService jwtService;
	
	public JwtAuthenticationController() {
		// TODO Auto-generated constructor stub
	}
	
	
	/*
    @RequestMapping(path = "/authenticate",method = RequestMethod.POST ,
    		consumes = MediaType.APPLICATION_JSON_VALUE, *
    		produces = MediaType.APPLICATION_JSON_VALUE)*/
	
	@PostMapping("/authenticate")
    public JwtResponse createJwtToken(@RequestBody JwtRequest jwtRequest) throws Exception {
        return jwtService.createJwtToken(jwtRequest);
    }
	
	/*
	 * 	@PostMapping("/authenticate")
    public JwtResponse createJwtToken(@RequestBody JwtRequest jwtRequest) throws Exception {
        return jwtService.createJwtToken(jwtRequest);
    }
	 */
}
