package com.example.prueba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.prueba.service.UsuarioService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	private UsuarioService servicioUsu;
	
	@RequestMapping("/lista")
	public String index(Model model) {
		return "login";
	}
	
	@RequestMapping("/ingresar")
    public String processLogin(@RequestParam String username, Model model, HttpSession session) {
        if (servicioUsu.sesionUsuario(username) != null) {
            session.setAttribute("username", username);
            return "redirect:/dashboard/lista";
        } else {
            model.addAttribute("MENSAJE", "Credenciales incorrectas");
            return "login";
        }
    }
}
