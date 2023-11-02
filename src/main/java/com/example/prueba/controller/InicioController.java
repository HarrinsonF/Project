package com.example.prueba.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/inicio")
public class InicioController {
	@RequestMapping("/lista")
	public String index(Model model) {
		return "inicio";
	}
}
