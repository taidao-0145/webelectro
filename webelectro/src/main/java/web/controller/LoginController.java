package web.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import web.data.TaiKhoanRepo;
import web.model.TaiKhoan;

@Controller
@RequestMapping("/dangnhap")
public class LoginController {
	
	
	private TaiKhoanRepo repo;
	@Autowired
	public LoginController(TaiKhoanRepo repo) {
		this.repo=repo;
	}
	
	@GetMapping
	public String dangnhap() {
		return "dangnhap";
	}
	@PostMapping
	public String dn(@RequestParam("username") String username,@RequestParam("pass") String pass,Model model,HttpSession ss) {
		List<TaiKhoan> list=repo.findByUsernameAndPass(username, pass);
		if(list.isEmpty()) {
			model.addAttribute("mess","Tên đăng nhập hoặc mật khẩu sai");
			return "dangnhap";
		}
		else {
			ss.setAttribute("tendn", username);
			model.addAttribute("tendnn",ss.getAttribute("tendn"));
			return "redirect:/user";
		}
	
		
	}
	
}
