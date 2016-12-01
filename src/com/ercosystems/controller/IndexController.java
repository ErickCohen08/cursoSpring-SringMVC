package com.ercosystems.controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.ercosystems.pojo.Admin;
import com.ercosystems.service.AdminService;

@Controller
@SessionAttributes("resultado")
public class IndexController {

	@Autowired
	private AdminService adminService;
	
	@RequestMapping("/")
	public String showIndex(Model model) {
		model.addAttribute("resultado", "Resultado desde Session");
		return "index";
	}
	
	@RequestMapping("/about")
	public String showAbout() {
		
		//guardar en bloque
		List<Admin> admins = new ArrayList<Admin>();
		Timestamp ts = new Timestamp(new Date().getTime());
		
		for (int i = 3001; i < 4001; i++) {
			admins.add(new Admin("Nombre "+i, "Cargo "+i, ts));
		}
		
		long TInicio, TFin, tiempo;
		TInicio = System.currentTimeMillis();
		
		adminService.saveAll(admins);
		
		TFin = System.currentTimeMillis();
		tiempo = TFin - TInicio;
		System.out.println("Tiempo de ejecución en milisegundos: " + tiempo);
		
		return "about";
	}
	
	
}
