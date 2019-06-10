package com.ataverna.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ataverna.helper.Response;
import com.ataverna.model.PartidaRPG;
import com.ataverna.model.Usuario;
import com.ataverna.repository.PartidaRPGRepository;
import com.ataverna.repository.UsuarioRepository;

@RestController
@RequestMapping(value = "/partida")
@CrossOrigin(origins = "*")
public class PartidaRPGController {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private PartidaRPGRepository partidaRPGRepository;

	@GetMapping
	public List<PartidaRPG> listar() {
		return this.partidaRPGRepository.findAll();
	}

	@PostMapping(value = "{id}")
	public ResponseEntity<Response<PartidaRPG>> cadastrar(@PathVariable("id") Integer id,
			@RequestBody PartidaRPG partida, BindingResult result) {

		Response<PartidaRPG> response = new Response<PartidaRPG>();

		Optional<Usuario> usuario = usuarioRepository.findById(id);

		if (!usuario.isPresent()) {
			response.getErros().add("Usuário não encontrado");
			return ResponseEntity.badRequest().body(response);
		}

		adicionarDadosPartida(partida);

		partidaRPGRepository.save(partida);

		response.setData(partida);

		return ResponseEntity.ok(response);
	}

	public void adicionarDadosPartida(PartidaRPG partida) {
		// Mestre
		partida.getMestre().setPartidaRPG(partida);

		// Historia
		partida.getHistoria().setPartidaRPG(partida);

		// Mapas
		for (int i = 0; i < partida.getMapas().size(); i++) {
			partida.getMapas().get(i).setPartidaRPG(partida);
		}

		// Grimorio
		for (int i = 0; i < partida.getGrimorio().size(); i++) {
			partida.getGrimorio().get(i).setPartidaRPG(partida);
		}

		// Jogadores
		for (int i = 0; i < partida.getJogadores().size(); i++) {
			partida.getJogadores().get(i).setPartidaRPG(partida);
		}

		// Bestiario
		for (int i = 0; i < partida.getBestiario().size(); i++) {
			partida.getBestiario().get(i).setPartidaRPG(partida);
		}

		// Enciclopedia
		for (int i = 0; i < partida.getEnciclopedia().size(); i++) {
			partida.getEnciclopedia().get(i).setPartidaRPG(partida);
		}
	}

	@GetMapping(value = "{id}")
	public ResponseEntity<Response<PartidaRPG>> buscarClientePorId(@PathVariable("id") Integer id) {

		Response<PartidaRPG> response = new Response<PartidaRPG>();

		Optional<PartidaRPG> partida = partidaRPGRepository.findById(id);

		if (!partida.isPresent()) {
			response.getErros().add("Partida não encontrado");
			return ResponseEntity.badRequest().body(response);
		}

		response.setData(partida.get());

		return ResponseEntity.ok(response);
	}

	@DeleteMapping(value = "{id}")
	public ResponseEntity<Response<PartidaRPG>> deletar(@PathVariable("id") Integer id) {

		Response<PartidaRPG> response = new Response<PartidaRPG>();

		Optional<PartidaRPG> partida = this.partidaRPGRepository.findById(id);

		if (!partida.isPresent()) {
			response.getErros().add("Partida não encontrada");
			ResponseEntity.badRequest().body(response);
		}

		response.setData(partida.get());

		this.partidaRPGRepository.delete(partida.get());

		return ResponseEntity.ok(response);
	}
	
	//Atualizar partida

}
