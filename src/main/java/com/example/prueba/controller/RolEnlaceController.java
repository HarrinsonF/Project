package com.example.prueba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.prueba.entity.Enlace;
import com.example.prueba.entity.Rol;
import com.example.prueba.entity.RolEnlace;
import com.example.prueba.service.EnlaceService;
import com.example.prueba.service.RolEnlaceService;
import com.example.prueba.service.RolService;

@Controller
@RequestMapping("/rolEnlace")
public class RolEnlaceController {

	@Autowired
	private RolEnlaceService servicioRolE;
	
	@Autowired 
	private RolService servicioRol;
	
	@Autowired 
	private EnlaceService servicioE;
	
	@RequestMapping("/lista")
	public String index(Model model) {
		model.addAttribute("rolEnlaces",servicioRolE.listarTodos());
		model.addAttribute("roles",servicioRol.listarTodos());
		model.addAttribute("enlaces",servicioE.listarTodos());
		return "rolEnlace";
	}
	
	@RequestMapping("/grabar")
	public String grabar(
			             @RequestParam("codigo") Integer cod,
			             @RequestParam("rol") int codR,
			             @RequestParam("enlace") int codE, 
			             RedirectAttributes redirect) {
		try {
			Rol rol = servicioRol.buscarPorID(codR);
			Enlace enlace = servicioE.buscarPorID(codE);
			
			
			boolean esDuplicado = servicioRolE.esCombinacionCodigosDuplicada(rol, enlace);
			
			if (esDuplicado) {
				redirect.addFlashAttribute("MENSAJE", "Esta combinaciòn de Rol y Enlace ya existe");
			} else {
				RolEnlace re = new RolEnlace();
				
				Rol r=new Rol();
				Enlace e=new Enlace();
				
				r.setCodigo(codR);
				e.setCodigo(codE);
				
				re.setRol(r);
				re.setEnlace(e);
				
				if(cod ==0){
				
				servicioRolE.registrar(re);
				redirect.addFlashAttribute("MENSAJE", "Acceso registrado");
				}
				else {
					re.setCodigo(cod);
					servicioRolE.actualizar(re);
					redirect.addFlashAttribute("MENSAJE", "Acceso actualizado");
				}
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			redirect.addFlashAttribute("ERROR", "Ocurrió un error al procesar la solicitud.");
		}
		return "redirect:/rolEnlace/lista";
	}

	@RequestMapping("/buscar")
	@ResponseBody 
	public RolEnlace buscar(@RequestParam("codigo") Integer cod)
	{
		return servicioRolE.buscarPorID(cod);
	}
	
	@RequestMapping("/eliminar")
	public String eliminar(@RequestParam("codigo") Integer cod, RedirectAttributes redirect) {
		
		servicioRolE.eliminarPorID(cod);
		redirect.addFlashAttribute("MENSAJE", "Acceso eliminado");
		return "redirect:/rolEnlace/lista";
	}
}
