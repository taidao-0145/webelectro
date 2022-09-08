package web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import web.data.TaiKhoanRepo;
import web.model.TaiKhoan;


@Controller
@RequestMapping("/dangki")
public class SignUpController {
	@Autowired
	private TaiKhoanRepo tkrepo;
	@GetMapping
	public String dk(Model model) {
		model.addAttribute("tk", new TaiKhoan());
		return "dangki";
	}
	@PostMapping
	public String dkk(@ModelAttribute TaiKhoan tk
			,@RequestParam("nlmk") String nlmk, Model model,RedirectAttributes ra) {
		List<TaiKhoan> list= tkrepo.findByUsername(tk.getPass());
		if(list.isEmpty()) {
			if(nlmk.equals(tk.getPass())) {
				tkrepo.save(tk);
				model.addAttribute("mess"," Đăng kí thành công");
				return "dangnhap";
			}
			else {
				ra.addFlashAttribute("mess2","Nhập lại mật khẩu");
				return "redirect:/dangki";
			}
			
		}
		else {
			ra.addFlashAttribute("mess2"," Tên đăng nhập đã tồn tại ");
			return "redirect:/dangki";
		}
		
			
		
		
	}
}
