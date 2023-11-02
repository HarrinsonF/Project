package com.example.prueba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.prueba.entity.Rol;
import com.example.prueba.entity.Usuario;
import com.example.prueba.service.UsuarioService;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
	@Autowired
	private UsuarioService servicioUsu;
	
	@RequestMapping("/lista")
	public String index(Model model) {
		model.addAttribute("usuario", servicioUsu.listarUsu());
		return "usuario";
	}
	@RequestMapping("/grabar")
	public String grabar(
			@RequestParam("codigo") Integer cod,
			@RequestParam("email") String ema,
			@RequestParam("password") String pass,
			@RequestParam("name") String nom,
			@RequestParam("lastname") String ape,
			@RequestParam("sexo") String sex,
			@RequestParam("rol")int codRol,			
			RedirectAttributes redirect) {
		try {
			Usuario usu = new Usuario();
			usu.setNombre(nom);
			usu.setApellido(ape);
			usu.setLogin(ema);
			usu.setClave(pass);
			usu.setSexo(sex);
			Rol ro= new Rol();
			ro.setCodigo(codRol);
			usu.setRol(ro);
		if(cod!=0) {
			servicioUsu.actualizar(usu);
			redirect.addFlashAttribute("MENSAJE","Usuario Actualizado con exito");
		}
		
		}catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/usuario/lista";
		
	}
	
	
	@RequestMapping("/buscar")
	@ResponseBody
	public Usuario buscar(@RequestParam("codigo") Integer cod ) {
		return servicioUsu.obtenerPoId(cod);
	}
	@RequestMapping("/eliminar")
	public String eliminar(@RequestParam("codigo") Integer cod,RedirectAttributes redirect) {
		servicioUsu.eliminar(cod);
		redirect.addFlashAttribute("MENSAJE","Usuario Eliminado");
		return "redirect:/usuario/lista";
	}
}
