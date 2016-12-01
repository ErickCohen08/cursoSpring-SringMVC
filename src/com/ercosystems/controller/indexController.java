package com.ercosystems.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@SessionAttributes("varIndexResultado")
public class indexController {
	
	@RequestMapping("/")
	public String showindex(Model model){
		model.addAttribute("varIndexResultado", "Resultado session desde el index");
		return "index";
	}

	@RequestMapping("/about")
	public String showAbout(SessionStatus sessionStatus){
		sessionStatus.setComplete();
		return "about";
	}
	
	@RequestMapping("/admin")
	public String showAdmin(Model model){
		model.addAttribute("mensaje", "Mensaje desde el model admin");
		return "admin";
	}
	
}
