package com.roberto.proyecto;

import java.sql.Connection;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.WebUtils;


import com.roberto.modelo.Oficinas;
import com.roberto.modelo.Operaciones;
import com.roberto.modelo.Regiones;
import com.roberto.modelo.Representantes;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	
	//BOTON VOLVER
	@RequestMapping(value="/volver", method = RequestMethod.GET)
	public String volver(){

	return "home" ;
	}
	
	
	
	//MENU PRINCIPAL
	
	
	//LISTAR REGIONES
	@RequestMapping(value = "/listarregiones", method = RequestMethod.GET)
	public String verregiones(Model model)
	{
		Operaciones op = new Operaciones();
		Connection cn = op.conexionmysql();
		ArrayList<Regiones> listarregiones = op.listarregiones(cn);
		model.addAttribute("listarregiones", listarregiones);
		
		return "listarregiones";
	}
	
	
	
	//LISTAR OFICINAS
	@RequestMapping(value = "/listaroficinas", method = RequestMethod.GET)
	public String veroficinas(Model model)
	{
		Operaciones op = new Operaciones();
		Connection cn = op.conexionmysql();
		ArrayList<Oficinas> listaroficinas = op.listaroficinas(cn);
		model.addAttribute("listaroficinas", listaroficinas);
		
		return "listaroficinas";
	}
	
	
	
	//MOSTRAR FORMULARIO REPRESENTANTES
	@RequestMapping(value = "/gestion", method = RequestMethod.GET)
	public String formularioRepresentantes(@Validated @ModelAttribute("representante") Representantes rep, BindingResult result, ModelMap model)
	{
		if (result.hasErrors()) {
			return "error";
		}
		return "gestion";
	}
	
	
	
	//------------------------------------------------------------------------------------------------------------------------------------------
	//------------------------------------------------------------------------------------------------------------------------------------------
	//------------------------------------------------------------------------------------------------------------------------------------------
	//------------------------------------------------------------------------------------------------------------------------------------------
	//------------------------------------------------------------------------------------------------------------------------------------------
	
	

	//OPERACIONES
	@RequestMapping(value="/operacionesrepresentantes", method = RequestMethod.POST)
	public String operacionesrepresentantes(Model modelo, @ModelAttribute("representante") Representantes rep, HttpServletRequest request) 
		{
		
		boolean insertar = WebUtils.hasSubmitParameter(request, "insertar");
		boolean borrar = WebUtils.hasSubmitParameter(request, "borrar");
		boolean modificar = WebUtils.hasSubmitParameter(request, "modificar");
		boolean volver = WebUtils.hasSubmitParameter(request, "volver");
		
		String mensaje="";
		
		if (volver) return "home";
		
		if (insertar) {
			Operaciones op = new Operaciones();
			Connection con = op.conexionmysql();
			mensaje=op.insertarRepresentante(rep, con);
		}
		
		if (borrar) {
			Operaciones op = new Operaciones();
			Connection con = op.conexionmysql();
			mensaje=op.borrarRepresentante(rep.getNumero_rep(), con);
		}
		
		
		if (modificar) {
			Operaciones op = new Operaciones();
			Connection con = op.conexionmysql();
			mensaje=op.modificarRepresentante(rep, con);
		}
		
		modelo.addAttribute("mensaje", mensaje);
		
		return "gestion";
		
		
		}
	
		
	
	
	//LISTADO REPRESENTANTES
	@ModelAttribute("listarrepresentantes")
	public List<Integer> listarRepresentantes() {
	   
		Operaciones op = new Operaciones();
		Connection cn = op.conexionmysql();
		List<Integer> listaRep = op.listarRepresentantes(cn);

		return listaRep;
	}
	
	//LISTADO DIRECTORES
	@ModelAttribute("listardirectores")
	public List<Integer> listarDirectores() {
	   
		Operaciones op = new Operaciones();
		Connection cn = op.conexionmysql();
		List<Integer> listaDir = op.listarDirectores(cn);
		
		return listaDir;
	}

	
}
