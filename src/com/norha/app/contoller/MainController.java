package com.norha.app.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.norha.app.entity.Product;
import com.norha.app.service.AppService;

@Controller
public class MainController {
	
	@Autowired
	private AppService appService;
	
	@RequestMapping(value = "/",method = RequestMethod.GET)
	public String homepage(Model model) {
		List<Product> products = appService.getProducts();
		model.addAttribute("products", products);
		return "homepage";
	}

}
