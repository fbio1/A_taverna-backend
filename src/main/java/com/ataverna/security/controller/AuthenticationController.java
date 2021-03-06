package com.ataverna.security.controller;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ataverna.helper.Response;
import com.ataverna.model.Usuario;
import com.ataverna.repository.UsuarioRepository;
import com.ataverna.security.dto.JwtAuthenticationDto;
import com.ataverna.security.dto.TokenDto;
import com.ataverna.security.utils.JwtTokenUtil;

@RestController
@RequestMapping("/login")
@CrossOrigin(origins = "*")
public class AuthenticationController {

	private static final Logger log = LoggerFactory.getLogger(AuthenticationController.class);
	private static final String TOKEN_HEADER = "Authorization";
	private static final String BEARER_PREFIX = "Bearer";

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@PostMapping
	public ResponseEntity<Response<TokenDto>> gerarTokenJwt(@Valid @RequestBody JwtAuthenticationDto authenticationDto,
			HttpServletResponse r, BindingResult result) throws AuthenticationException {

		Response<TokenDto> response = new Response<TokenDto>();

		if (result.hasErrors()) {

			log.error("Erro validando usuário: {}", result.getAllErrors());
			result.getAllErrors().forEach(error -> response.getErros().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);

		}

		log.info("Gerando token para o Username {}.", authenticationDto.getUsername());
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(authenticationDto.getUsername(), authenticationDto.getSenha()));

		SecurityContextHolder.getContext().setAuthentication(authentication);

		UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationDto.getUsername());

		String token = jwtTokenUtil.obterToken(userDetails);
		response.setData(new TokenDto(/* BEARER_PREFIX+ " " +*/token));

		Optional<Usuario> usuario = this.usuarioRepository.findByUsernameAndAtivoTrue(authenticationDto.getUsername());
		
		r.addHeader(TOKEN_HEADER, BEARER_PREFIX + " " + token);
		r.addHeader("Usuario","ID:"+usuario.get().getId());
		//r.addHeader("UsuarioPerfil:","Perfil:"+usuario.get().getUsername());		
		
		return ResponseEntity.ok(response);
	}

	@PostMapping(value = "/refresh")
	public ResponseEntity<Response<TokenDto>> gerarRefreshTokenJwt(HttpServletRequest request) {
		log.info("Gerando novo token JWT.");

		Response<TokenDto> response = new Response<TokenDto>();
		Optional<String> token = Optional.ofNullable(request.getHeader(TOKEN_HEADER));

		if (token.isPresent() && token.get().startsWith(BEARER_PREFIX)) {
			token = Optional.of(token.get().substring(7));
		}

		if (!token.isPresent()) {
			response.getErros().add("Token não informado.");
		} else if (!jwtTokenUtil.tokenValido(token.get())) {
			response.getErros().add("Token inválido ou expirado.");
		}

		if (!response.getErros().isEmpty()) {
			return ResponseEntity.badRequest().body(response);
		}

		String refreshedToken = jwtTokenUtil.refreshToken(token.get());
		response.setData(new TokenDto(refreshedToken));

		return ResponseEntity.ok(response);

	}

}
