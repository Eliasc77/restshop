package com.example.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.example.demo.security.jwt.JwtAuthenticationEntryPoint;
import com.example.demo.security.jwt.JwtRequestFilter;



@Configuration//para indicar q esta clase es de configuracion
@EnableWebSecurity// y que permita configurar la seguridad web
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private UserDetailsService userDetailsService;
	
	// que use al autorizacion entrypoint
	//@Autowired
	//private  JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

	// que use el filtro
	//@Autowired
	//private JwtRequestFilter jwtRequestFilter;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {		
		
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
		
	}
	//Sirve para manejar el control de acceso a mis url
		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http.cors().and()
			.csrf().disable()
			.authorizeRequests().antMatchers("/distrito/**","/usuario/**","/producto/**","/categoria/**","/rol/listar","/usuario/listar","/authenticate", "/usuario/registerNewUser").permitAll()	
			.antMatchers(HttpHeaders.ALLOW).permitAll()
			.anyRequest().authenticated();
			//.and();
			//.exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint)
			//.and()
			//.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
			//http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);

		}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
	//para q este decorado en el contexto de spring // si no se abilita en el contexto no va funcionar en el controlador por que no va poder cablearlo de maneara automatica
	@Bean 
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
	
		return super.authenticationManagerBean();
	}
	

}
