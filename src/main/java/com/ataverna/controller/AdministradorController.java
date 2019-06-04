package com.ataverna.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/administrador")
@CrossOrigin(origins = "*")
public class AdministradorController {

	@RequestMapping(method = RequestMethod.GET)
	public String findById() {
		return "REST está adm123";
	}

}
