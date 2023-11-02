package com.example.prueba.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.prueba.entity.Rol;
import com.example.prueba.service.RolService;
@Controller
@RequestMapping("/rol")
public class RolController {

	@Autowired
	private RolService servicioRol;
	
	@RequestMapping("/lista")
	public String index(Model model) {
		model.addAttribute("roles",servicioRol.listarTodos());
		return "rol";
	}
	
	@RequestMapping("/grabar")
	public String grabar(@RequestParam("codigo") Integer cod,
			             @RequestParam("descripcion") String des, 
			             RedirectAttributes redirect) {
		try {
			boolean esDuplicado = servicioRol.esDescripcionRolDuplicada(des);
			if(esDuplicado) {
				redirect.addFlashAttribute("MENSAJE", "El rol con este nombre ya existe");
			} else {
				Rol med = new Rol();
				med.setDescripcion(des);

				if(cod ==0){

				servicioRol.registrar(med);

				redirect.addFlashAttribute("MENSAJE", "Rol registrado");
				}
				else {
					med.setCodigo(cod);
					servicioRol.actualizar(med);
					redirect.addFlashAttribute("MENSAJE", "Rol actualizado");
				}
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			redirect.addFlashAttribute("ERROR", "Ocurrió un error al procesar la solicitud.");
		}
		return "redirect:/rol/lista";
	}

	@RequestMapping("/buscar")
	@ResponseBody
	public Rol buscar(@RequestParam("codigo") Integer cod)
	{
		return servicioRol.buscarPorID(cod);
	}
	
	@RequestMapping("/eliminar")
	public String eliminar(@RequestParam("codigo") Integer cod, RedirectAttributes redirect) {
		
		servicioRol.eliminarPorID(cod);
		redirect.addFlashAttribute("MENSAJE", "Rol eliminadao");
		return "redirect:/rol/lista";
	}
}
