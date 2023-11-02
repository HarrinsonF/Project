package com.example.prueba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.prueba.entity.Doctor;
import com.example.prueba.entity.Especialidad;
import com.example.prueba.service.DoctorService;
import com.example.prueba.service.EspecialidadService;

@Controller
@RequestMapping("/doctor")
public class DoctorController {
	@Autowired
	private DoctorService servicioDoc;
	@Autowired
	private EspecialidadService servicioEspe;
	
	@RequestMapping("/lista")
	public String index(Model model) {
		model.addAttribute("doctor", servicioDoc.listarDoc());
		model.addAttribute("especialidad", servicioEspe.listarEspe());
		return "doctor";
	}
	
	@RequestMapping("/grabar")
	public String grabar(
			@RequestParam("codigo") Integer cod,
			@RequestParam("nombre") String nom,
			@RequestParam("apellido") String ape,
			@RequestParam("edad") int edad,
			@RequestParam("email") String email,
			@RequestParam("cmp") String cmp,
			@RequestParam("especialidad") int codEsp,
			RedirectAttributes redirect) {
		try {
			Doctor doc = new Doctor();
			doc.setNombre(nom);
			doc.setApellido(ape);
			doc.setEdad(edad);
			doc.setEmail(email);
			doc.setCmp(cmp);
			
			boolean duplicado = servicioDoc.cmpExiste(cmp);
			if(duplicado) {
				redirect.addFlashAttribute("MENSAJE", "CMP ya existente");
			}
			else {
				Especialidad esp = new Especialidad();
				esp.setCodigo(codEsp);
				doc.setEsp(esp);
				
				if(cod==0) {
					servicioDoc.registrar(doc);
					redirect.addFlashAttribute("MENSAJE", "Doctor Registrado");
				}
				else {
					doc.setCodigo(cod);
					servicioDoc.actualizar(doc);
					redirect.addFlashAttribute("MENSAJE", "Doctor Actualizar");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			redirect.addFlashAttribute("MENSAJE", "Error de en el registro");
		}
		return "redirect:/doctor/lista";
	}
	@RequestMapping("/buscar")
	@ResponseBody
	public Doctor buscar(@RequestParam("codigo") Integer cod ) {
		return servicioDoc.obtenerPorId(cod);
	}
	@RequestMapping("/eliminar")
	public String eliminar(@RequestParam("codigo") Integer cod,RedirectAttributes redirect) {
		servicioDoc.eliminar(cod);
		redirect.addFlashAttribute("mensaje","DoctorEliminado");
		return "redirect:/doctor/lista";
	}
}
