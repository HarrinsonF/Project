package com.example.prueba.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/boleta")
public class BoletaController {
	@RequestMapping("/lista")
	public String index(Model model) {
		return "boleta";
	}
}
