package com.roberto.proyecto;

import java.sql.Connection;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.roberto.modelo.Operaciones;
import com.roberto.modelo.Regiones;

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
	
}
