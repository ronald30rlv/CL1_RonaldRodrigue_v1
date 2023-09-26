package com.cibertec.edu.pe.controller;

import java.text.ParseException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cibertec.edu.pe.entity.Categoria;
import com.cibertec.edu.pe.entity.Cliente;
import com.cibertec.edu.pe.services.IClienteServicec;


@Controller
@RequestMapping("/cliente")
public class ClienteController {
	@Autowired
	private IClienteServicec servicio;
	//Creando el listado de Clientes 
		@GetMapping("/listado") //Para que lo pruebes en el localhost de la web
		public String Listado(Model model) throws ParseException {
			String cabecera="Listado de Clientes";
			String title="Listado";
			ArrayList<Cliente> listado=new ArrayList<>();
			listado.add(new Cliente("Ronald", "Rodriguez","ronald_123@gmail.com" , "1990-05-01", "41452148",new Categoria("Abogado")));
			listado.add(new Cliente("Carmen", "Sanchez","csamchez@gmail.com" , "1995-08-01", "42518745",new Categoria("Ingeniero")));
			listado.add(new Cliente("Angel", "Torres","atorres21@gmail.com" , "1992-12-11", "42365120",new Categoria("Doctor")));
			listado.add(new Cliente("Alejandra", "Salazar","asalazar_123@gmail.com" , "1998-02-12", "46523021",new Categoria("Administrador")));

			model.addAttribute("lista",listado);
			model.addAttribute("title",title);
			model.addAttribute("msg1",cabecera);
			return "listado";
		}
		@PostMapping("/registar")
		public String guardarEstudiante(@ModelAttribute("cliente")Cliente cliente) {
			servicio.registrarCliente(cliente);
			return "redirect:/estudiantes";
		}
}
