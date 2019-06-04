package com.ataverna.controller;

import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ataverna.helper.PasswordUtils;
import com.ataverna.helper.Response;
import com.ataverna.model.Usuario;
import com.ataverna.repository.UsuarioRepository;

@RestController
@RequestMapping(value = "/usuario")
@CrossOrigin(origins = "*")
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@GetMapping
	public List<Usuario> listarClientes() {
		List<Usuario> usuarios = this.usuarioRepository.findAll();
		return usuarios;
	}

	@PostMapping
	public ResponseEntity<Response<Usuario>> cadastrarCliente(
			@Valid @RequestBody Usuario usuario, BindingResult result) throws NoSuchAlgorithmException {

		Response<Usuario> response = new Response<Usuario>();

		validarDadosExistentes(usuario, result);

		if (result.hasErrors()) {			
			result.getAllErrors().forEach(error -> response.getErros().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}
		
		usuario.setSenha(PasswordUtils.gerarBCrypt(usuario.getSenha()));		
		response.setData(this.usuarioRepository.save(usuario));
		
		return ResponseEntity.ok(response);
	}

	@GetMapping(value = "{id}")
	public ResponseEntity<Response<Usuario>> buscarClientePorId(@PathVariable("id") Integer id) {

		Response<Usuario> response = new Response<Usuario>();

		Optional<Usuario> usuario = this.usuarioRepository.findById(id);

		if (!usuario.isPresent()) {
			response.getErros().add("Usuário não encontrado");
			return ResponseEntity.badRequest().body(response);
		}

		response.setData(usuario.get());

		return ResponseEntity.ok(response);
	}

	@PutMapping(value = "{id}")
	public ResponseEntity<Response<Usuario>> atualizarCliente(@PathVariable("id") Integer id,
			@Valid @RequestBody Usuario usuario, BindingResult result) throws NoSuchAlgorithmException {

		Response<Usuario> response = new Response<Usuario>();

		Optional<Usuario> oldUsuario = this.usuarioRepository.findById(id);

		if (!oldUsuario.isPresent()) {			
			result.addError(new ObjectError("usuario", "Usuario não encontrado."));
			return ResponseEntity.badRequest().body(response);
		}

		this.atualizarDadosCliente(oldUsuario.get(), usuario, result);

		if (result.hasErrors()) {			
			result.getAllErrors().forEach(error -> response.getErros().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}

		this.usuarioRepository.save(oldUsuario.get());
		
		response.setData(oldUsuario.get());

		return ResponseEntity.ok(response);

	}

	@DeleteMapping(value = "{id}")
	public ResponseEntity<Response<Usuario>> deletarCliente(@PathVariable("id") Integer id) {

		Response<Usuario> response = new Response<Usuario>();

		Optional<Usuario> usuario = this.usuarioRepository.findById(id);

		if (!usuario.isPresent()) {		
			response.getErros().add("Usuario não encontrado");
			return ResponseEntity.badRequest().body(response);
		}

		response.setData(usuario.get());

		this.usuarioRepository.deleteById(usuario.get().getId());

		return ResponseEntity.ok(response);
	}
	
	private void validarDadosExistentes(Usuario usuario, BindingResult result) {

		this.usuarioRepository.findByUsernameAndAtivoTrue(usuario.getUsername())
				.ifPresent(cre -> result.addError(new ObjectError("usuario", "Username já existente")));

	}
	
	private void atualizarDadosCliente(Usuario oldUsuario, Usuario newUsuario, BindingResult result)
			throws NoSuchAlgorithmException {

		if (!oldUsuario.getEmail().equals(newUsuario.getEmail())) {

			this.usuarioRepository.findByEmailAndAtivoTrue(newUsuario.getEmail())
					.ifPresent(clien -> result.addError(new ObjectError("email", "Email já exitente.")));
			oldUsuario.setEmail(newUsuario.getEmail());
		}			

		if (newUsuario.getUsername() != null || newUsuario.getSenha() != null) {

			if (!oldUsuario.getUsername().equals(newUsuario.getUsername())) {

				this.usuarioRepository.findByUsernameAndAtivoTrue(newUsuario.getUsername())
						.ifPresent(clien -> result.addError(new ObjectError("username", "Username já exitente.")));
				oldUsuario.setUsername(newUsuario.getUsername());
			}	

			oldUsuario.setSenha(PasswordUtils.gerarBCrypt(newUsuario.getSenha()));

		} else {
			oldUsuario.setUsername(oldUsuario.getUsername());
			oldUsuario.setSenha(oldUsuario.getSenha());
		}
	}
}
