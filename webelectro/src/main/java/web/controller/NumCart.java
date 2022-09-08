package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import web.data.CartRepo;

@Controller
@RequestMapping("/numCart")
public class NumCart {
	private CartRepo repo;
	@Autowired
	public NumCart (CartRepo repo) {
		this.repo=repo;
	}
	@GetMapping   
	public String numcart(@RequestParam("id") Long id,@RequestParam("check") String check,
			@RequestParam("idpro") Long idpro,@RequestParam("num") int num ) {
		if(check.equals("plus")) {
			repo.numplus(id);
		}
		else {
			if(num<2) {
				return "redirect:/viewcart";
			}
			else {
				repo.numminus(id);
			}
			
		}
		return "redirect:/viewcart";
	}
}
