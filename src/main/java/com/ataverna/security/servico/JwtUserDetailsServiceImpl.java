package com.ataverna.security.servico;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ataverna.model.Usuario;
import com.ataverna.repository.UsuarioRepository;
import com.ataverna.security.JwtUserFactory;

@Service("userDetailsService")
public class JwtUserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Usuario> ususario = this.usuarioRepository.findByUsernameAndAtivoTrue(username);

		if (ususario.isPresent()) {
			return JwtUserFactory.create(ususario.get());
		}

		throw new UsernameNotFoundException("Username não Encontrado.");
	}

}
