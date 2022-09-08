package web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import web.data.CartRepo;
import web.data.ProductRepo;
import web.model.Cart;

@Controller
@RequestMapping("/addcart")
public class AddToCart {
	
	private ProductRepo prorepo;
	private CartRepo cartrepo;
	@Autowired
	public AddToCart(CartRepo cartrepo,ProductRepo prorepo) {
		this.cartrepo=cartrepo;
		this.prorepo=prorepo;
	}
	
	
	@GetMapping
	public String addcart(@RequestParam("id") Long id, HttpSession ss, Model model) {		
		model.addAttribute("tendnn",ss.getAttribute("tendn"));
		String username = (String) ss.getAttribute("tendn");
		
		int gia= prorepo.getById(id).getGia();
		String img= prorepo.getById(id).getImg();
		String tensp=prorepo.getById(id).getTensp();
		int soluong=prorepo.getById(id).getSoluong();
		Cart cart= new Cart( username, id, tensp, img, gia, 1, gia);
		if(soluong >0) {
			if(cartrepo.checkcart(username, id).isEmpty()) {
				cartrepo.save(cart);
			}
			else {
				cartrepo.updatecheck(username, id);
			}
			
		}
		else {
			return "redirect:/user";	
		}
		return "redirect:/user";
	}

}
