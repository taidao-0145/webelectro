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
@RequestMapping("/store")
public class StoreController {
	private CartRepo cartrepo;
	@Autowired
	public StoreController(CartRepo cartrepo) {
		this.cartrepo=cartrepo;
	}
	@GetMapping
	public String store(HttpSession ss, Model model) {
		model.addAttribute("tendnn",ss.getAttribute("tendn"));
		String name=(String) ss.getAttribute("tendn");
		
		List<Cart> listsmall= cartrepo.findByUsername(name);
		model.addAttribute("listsmall",listsmall);
		int tong=0;
		for(Cart cart:listsmall) {
			tong+=cart.getTong();
		}
		model.addAttribute("tong",tong);
		return "store";
	}
}
