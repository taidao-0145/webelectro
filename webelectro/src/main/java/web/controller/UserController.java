package web.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import web.data.CartRepo;
import web.data.ProductRepo;
import web.model.Cart;
import web.model.Product;

@Controller
@RequestMapping("/user")
public class UserController {
	private ProductRepo repo;
	private CartRepo cartrepo;
	@Autowired
	public UserController (ProductRepo repo,CartRepo cartrepo) {
		this.repo=repo;
		this.cartrepo=cartrepo;
	}
	@GetMapping
	public String user(Model model,HttpSession ss) {
		model.addAttribute("tendnn",ss.getAttribute("tendn"));
		String name= (String) ss.getAttribute("tendn");
		List<Product> list= repo.listnew();
		model.addAttribute("list",list);
		
		   
		List<Product> listsale= repo.listsale();
		model.addAttribute("listsale",listsale);
		
		List<Cart> listsmall= cartrepo.findByUsername(name);
		model.addAttribute("listsmall",listsmall);
		int tong=0;
		for(Cart cart:listsmall) {
			tong+=cart.getTong();
		}
		model.addAttribute("tong",tong);
		
		return "user";
	}

}
