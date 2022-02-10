package com.example.demo.security.jwt;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.demo.service.JwtService;
import com.example.demo.service.UsuarioService;

import io.jsonwebtoken.ExpiredJwtException;

//@Component
public class JwtRequestFilter extends OncePerRequestFilter {
	
	@Autowired
	private JwtService jwtService;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;


	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub


			final String requestTokenHeader = request.getHeader("Authorization");

			String userName = null;
			String jwtToken = null;

			if (requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")) {
				// token jwt esta presente en la peticione
				jwtToken = requestTokenHeader.substring(7);
				
				try {
					userName = jwtTokenUtil.getUsernameFromToken(jwtToken);// usuario para quien se genero el token
				} catch (IllegalArgumentException e) {
					System.out.println("Unable to get JWT Token");
				} catch (ExpiredJwtException e) {
	                System.out.println("JWT Token has expired");
	            } 
			} else {
	            	System.out.println("JWT Token doesnt start with bearer");	        
			}
	
			if (userName != null && SecurityContextHolder.getContext().getAuthentication() == null) {

					// si usuario diferente de nullo y no hay contexto de seguridad
					UserDetails userDetails = jwtService.loadUserByUsername(userName);

					if (jwtTokenUtil.validateToken(jwtToken, userDetails)) {
						// si el token es valido se genera un contexto de seguridad
			              UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
			                usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
			                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
					} 
			}
			 
		
		filterChain.doFilter(request, response);

	}

}
