package com.norha.app.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.norha.app.entity.Product;
import com.norha.app.service.AppService;

@Controller
public class MainController {
	
	@Autowired
	private AppService appService;
	
	@GetMapping("/")
	public String homepage(Model model) {
		List<Product> products = appService.getProducts();
		model.addAttribute("products", products);
		return "homepage";
	}

	@GetMapping("/addProductForm")
	public String addProductForm(Model model) {
		Product product = new Product();
		model.addAttribute("product", product);
		return "addProductForm";
	}
	@PostMapping("/addProduct")
	public String addProduct(@ModelAttribute("product") Product product) {
		System.out.println(product);
		appService.addProduct(product);
		return "redirect:/";
	} 
	@GetMapping("/updateProductForm")
	public String updateProductForm(@RequestParam("id") int id,
			Model model) {
		Product product = appService.getProduct(id);
		model.addAttribute("product", product);
		return "addProductForm";
	}
	@GetMapping("/deleteProduct")
	public String deleteProduct(@RequestParam("id") int id) {
		appService.deleteProduct(id);
		return "redirect:/";
	}
}
