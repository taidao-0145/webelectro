package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import web.data.CartRepo;

@Controller
@RequestMapping("/deletecart")
public class DeleteCart {
	private CartRepo repo;
	@Autowired
	public DeleteCart (CartRepo repo) {
		this.repo=repo;
	}
	@GetMapping
	public String deletecart(@RequestParam("id") Long id) {
		repo.deleteById(id);
		return "redirect:/viewcart";
	}
}
