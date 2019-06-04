package com.ataverna;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.ataverna.helper.PasswordUtils;
import com.ataverna.model.Usuario;
import com.ataverna.repository.UsuarioRepository;

@SpringBootApplication
public class ATarvenaBackEndApplication {

	public static void main(String[] args) {
		SpringApplication.run(ATarvenaBackEndApplication.class, args);
	}
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Bean
	public CommandLineRunner commandLineRunner() {
		return args -> {
			Usuario usuario = new Usuario();
			usuario.setEmail("teste@email.com");
			usuario.setUsername("teste");
			usuario.setSenha(PasswordUtils.gerarBCrypt("teste"));
			usuarioRepository.save(usuario);
			
		};
	}

}
