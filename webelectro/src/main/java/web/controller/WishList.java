package web.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import web.data.WishRepo;
import web.model.Wish;

@Controller
@RequestMapping("/wishlist")
public class WishList {
	private WishRepo repo;
	@Autowired
	public WishList(WishRepo repo) {
		this.repo=repo;
	}
	@GetMapping
	public String wishlist(Model model ,HttpSession ss) {
		String username = (String) ss.getAttribute("tendn");
		model.addAttribute("tendnn",ss.getAttribute("tendn"));
		List<Wish> list= repo.findByUsername(username);	
		model.addAttribute("list",list);
		return "wishlist";
	}
}
