package com.ataverna.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/partida")
@CrossOrigin(origins = "*")
public class PartidaRPGController {

	@GetMapping
	public String findById() {
		return "REST";
	}
}
