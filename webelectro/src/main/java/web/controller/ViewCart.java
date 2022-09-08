package web.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import web.data.CartRepo;
import web.model.Cart;

@Controller
@RequestMapping("/viewcart")
public class ViewCart {
	private CartRepo repo;
	@Autowired
	public ViewCart (CartRepo repo) {
		this.repo= repo;
	}
	
	@GetMapping
	public String viewcart(HttpSession ss,Model model) {
		model.addAttribute("tendnn",ss.getAttribute("tendn"));
		String name= (String) ss.getAttribute("tendn");
		List<Cart> list= repo.findByUsername(name);
		model.addAttribute("listcart",list);
		
		int tong=0;
		for(Cart cart:list) {
			tong+=cart.getTong();
		}
		model.addAttribute("tong",tong);
		return "viewcart";
	}
}
