package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Usuario;

@Repository
@Transactional
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

	Optional<Usuario>findUserByEmail(String email);
	
	/*
	@Query(value="SELECT m.password from usuario m where m.email =?1",nativeQuery = true)
	public Usuario findbyemail(String email);
	*/
    @Query(value = "SELECT * FROM usuario u WHERE u.email =:correo and u.password= :passwd", nativeQuery = true)
    public List<Usuario> userLogin(@Param("correo")String correo,@Param("passwd")String passwd);
	
    @Query("SELECT U FROM Usuario U WHERE U.email=:correo AND U.password=:passwd")
    Optional<Usuario> login2(String correo, String passwd);

}
