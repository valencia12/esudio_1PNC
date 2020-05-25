package com.uca.capas.mundo.controller;

import java.util.Date;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.mundo.domain.Contribuyente;
import com.uca.capas.mundo.domain.Importancia;
import com.uca.capas.mundo.service.contribuyenteService;
import com.uca.capas.mundo.service.importanciaService;

import javax.validation.Valid;

@Controller
public class MainController {
	
	@Autowired
    private contribuyenteService contService;
	@Autowired
	private importanciaService impService;
	
	
	@RequestMapping("/inicio")
	public ModelAndView initMain() {
		ModelAndView mav = new ModelAndView();
		List<Importancia> importancia = null;
		   try {
			   importancia = impService.allImportancias();
	        }catch (Exception e){
	            e.printStackTrace();
	        }
		   mav.addObject("importancias", importancia);
		   mav.addObject("contribuyente", new Contribuyente());	
		   mav.setViewName("index");
		return mav;
		
	}

	@PostMapping("/insertar")
	public ModelAndView save(@Valid @ModelAttribute Contribuyente contribuyente, BindingResult result){
		ModelAndView mav = new ModelAndView();
		List<Importancia> importancia = null;
		if(result.hasErrors()){
			importancia = impService.allImportancias();
			mav.addObject("importancias",importancia);
			mav.setViewName("index");
		}else{
			Date date = new Date();
			contribuyente.setfIngreso(date);
			try {
				contService.insertarContribuyente(contribuyente);
				mav.setViewName("mensaje");
			}catch (Exception e){
				e.printStackTrace();
			}
		}
		return mav;
	}

	@PostMapping("/contribuyentes")
	public ModelAndView lista(){
		ModelAndView mav = new ModelAndView();
		List<Contribuyente> contribuyentes = null;
		try{
			contribuyentes = contService.findAllContribuyentes();
		}catch (Exception e){
			e.printStackTrace();
		}
		mav.addObject("contribuyentes", contribuyentes);
		mav.setViewName("lista");
		return mav;
	}


	
}
