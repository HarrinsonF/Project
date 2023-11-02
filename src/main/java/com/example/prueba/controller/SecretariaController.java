package com.example.prueba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.prueba.entity.Modulo;
import com.example.prueba.entity.Secretaria;
import com.example.prueba.service.ModuloServices;
import com.example.prueba.service.SecretariaServices;

@Controller
@RequestMapping("/secretaria")
public class SecretariaController {
	
	@Autowired
	private SecretariaServices servicioSe;
	
	@Autowired
	private ModuloServices servicioMo;
	
	
	@RequestMapping("/lista")
	public String index(Model model) {
		model.addAttribute("secretaria", servicioSe.listarTodos());
		model.addAttribute("modulo",servicioMo.listarTodos());
		return "secretaria";
	}
	
	
	
	@RequestMapping("/grabar")
	public String grabar(@RequestParam("codigo") Integer cod,
						@RequestParam("nombre") String nom,
						@RequestParam("apellido") String ape,
						@RequestParam("edad") int edad,
						@RequestParam("email") String email,
						@RequestParam("telefono") int tel,
						@RequestParam("modulo")int codMod,
						RedirectAttributes redirect) {
		
		try {
			
			Secretaria se= new Secretaria();
			
			se.setNombre(nom);
			se.setApellido(ape);
			se.setEdad(edad);
			se.setEmail(email);
			se.setTelefono(tel);
			
			
			Modulo mo=new Modulo();
			
			mo.setCodigo(codMod);
			se.setModulo(mo);
			
			if(cod==0) {
				//invocar mètodo registrar
				servicioSe.registrar(se);
				//crear atributo de tipo flash
				redirect.addFlashAttribute("MENSAJE","Secretaria registrada");
			}
			else {
				//setear atributo còdigo
				se.setCodigo(cod);
				servicioSe.actualizar(se);
				redirect.addFlashAttribute("MENSAJE","Secretaria actualizada");
			}
		
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/secretaria/lista";
	}
	
	@RequestMapping("/buscar")
	@ResponseBody
	public Secretaria buscar(@RequestParam("codigo")Integer cod) {
		return servicioSe.buscarporID(cod);
	}
	
	@RequestMapping("/eliminar")
	public String eliminar(@RequestParam("codigo") Integer cod ,RedirectAttributes redirect) {
		servicioSe.eliminarPorID(cod);
		redirect.addFlashAttribute("MENSAJE", "Secretaria eliminada");
		return "redirect:/secretaria/lista";
		
	}

}
