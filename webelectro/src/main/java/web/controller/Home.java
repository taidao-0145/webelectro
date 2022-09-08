package web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import web.data.ProductRepo;

import web.model.Product;

@Controller
@RequestMapping("/")
public class Home {
	
	private ProductRepo repo;
	@Autowired
	public Home (ProductRepo repo) {
		this.repo=repo;
	}
	@GetMapping
	public String home(Model model) {
		   List<Product> list= repo.listnew();	   
		   model.addAttribute("list",list);
		   
		   List<Product> listsale= repo.listsale();
		   model.addAttribute("listsale",listsale);
		return "index";
	}
	
}
