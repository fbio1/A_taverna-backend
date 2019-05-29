package com.atarvena;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.atarvena.model.Usuario;
import com.atarvena.repository.UsuarioRepository;

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
			usuario.setEmail("pedro@email.com");
			usuario.setUsername("Pedro123");
			usuario.setSenha("123");
			usuarioRepository.save(usuario);
			
		};
	}

}
