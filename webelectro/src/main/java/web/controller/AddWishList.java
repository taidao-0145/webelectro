package web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import web.data.ProductRepo;
import web.data.WishRepo;
import web.model.Product;
import web.model.Wish;

@Controller
@RequestMapping("/addwishlist")
public class AddWishList {
	private ProductRepo prorepo;   
	private WishRepo wishrepo;
	@Autowired
	public AddWishList(ProductRepo prorepo,WishRepo wishrepo) {
		this.prorepo=prorepo;
		this.wishrepo=wishrepo;
	}


	@GetMapping
	public String wishlist(@RequestParam("id") Long id, HttpSession ss) {
		String username = (String) ss.getAttribute("tendn");
		Product pro=prorepo.getById(id);
		String tensp=pro.getTensp();
		int gia=pro.getGia();
		int sl=pro.getSoluong();
		String img= pro.getImg();
		Wish w= new Wish( username, tensp, gia, sl, img);
		wishrepo.save(w);
		return "redirect:/user";
	}
}
