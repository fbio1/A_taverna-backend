package com.ataverna.repository;

import java.util.Optional;

import com.ataverna.model.Usuario;

public interface UsuarioRepository extends GenericRepository<Usuario, Integer> {
	
	Optional<Usuario> findByUsernameAndAtivoTrue(String username);
	
	Optional<Usuario> findByEmailAndAtivoTrue(String email);

}
