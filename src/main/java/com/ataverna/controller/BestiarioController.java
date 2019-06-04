package com.ataverna.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/bestiario")
@CrossOrigin(origins = "*")
public class BestiarioController {

	@GetMapping
	public String findById() {
		return "REST";
	}

}
