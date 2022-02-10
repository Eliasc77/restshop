package com.example.demo.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.modelo.Usuario;
import com.example.demo.service.UsuarioService;
 

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/usuario")
public class UsuarioRestController {

	@Autowired
	private UsuarioService serv;
	
	
	   @PostConstruct
	    public void initRoleAndUser() {
		   serv.initRoleAndUser();
	    }
	
	@GetMapping("/listar")
	public ResponseEntity<?> findAll(){
		Object lista = serv.findAll();
		return new ResponseEntity<>(lista, HttpStatus.OK);
	}
	
	@GetMapping("/listar/{id}")
	public ResponseEntity<?>findbyId(@PathVariable int id){
		Object lista = serv.findById(id);
		return new ResponseEntity<>(lista,HttpStatus.OK);
	}
	

	@PostMapping("/registerNewUser")
	public ResponseEntity<?> insert(@RequestBody Usuario user){
		Object list = serv.registerNewUser(user);
		return new ResponseEntity<>(list, HttpStatus.CREATED);
	}
	


	@PutMapping("/update/{usuarioId}")
	@ApiOperation(value = "Actualiza los datos del Usuario", httpMethod = "PUT", nickname = "updateUsuarios")
	public ResponseEntity<?>update(@PathVariable Integer usuarioId, @RequestBody Usuario newUsuario){
		
		Usuario usuario= serv.findById(usuarioId);
		if(usuario == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente no encontrado");
		}
		Object list = serv.updateUser(newUsuario);
		return new ResponseEntity<>(list ,HttpStatus.OK);
	}
	
	
	@DeleteMapping("/delete/{usuarioId}")
	@ApiOperation(value = "Elimina el Registro de un Usuario", httpMethod = "DELETE", nickname = "agregarUsuarios")
	public ResponseEntity<?>delete(@PathVariable Integer usuarioId){
		Usuario usuario= serv.findById(usuarioId);
		if(usuario == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente no encontrado");
		}
		serv.delete(usuarioId);
		Map<String,String> respuesta = new HashMap<String, String>(); //adhoc metodo
		respuesta.put("codigo","O0");
		respuesta.put("mensaje", "Se elimino correctamente el Usuario con id : " + usuarioId);
		respuesta.put("fecOperacion",new Date().toString());
		return new ResponseEntity<>(respuesta,HttpStatus.ACCEPTED);
	}
}
