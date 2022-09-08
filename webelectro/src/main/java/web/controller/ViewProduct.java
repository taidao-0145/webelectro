package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import web.data.ProductRepo;
import web.model.Product;

@Controller
@RequestMapping("/viewproduct")
public class ViewProduct {
	private ProductRepo repo;
	@Autowired
	public ViewProduct (ProductRepo repo) {
		this.repo=repo;
	}
	@GetMapping
	public String viewproduct(@RequestParam("id") Long id, Model model) {
		Product product= repo.getById(id);
		model.addAttribute("product",product);
		
		return "viewproduct";
	}

}
