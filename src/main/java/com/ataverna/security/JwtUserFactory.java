package com.ataverna.security;

import com.ataverna.model.Usuario;

public class JwtUserFactory {

	private JwtUserFactory() {

	}

	public static JwtUser create(Usuario usuario) {
		return new JwtUser(usuario.getId(), usuario.getUsername(), usuario.getSenha());
	}

//	private static List<GrantedAuthority> mapToGrantedAuthorities(EnumTipoPerfilUsuario perfilEnum) {
//		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
//		authorities.add(new SimpleGrantedAuthority(perfilEnum.toString()));
//		return authorities;
//
//	}

}
