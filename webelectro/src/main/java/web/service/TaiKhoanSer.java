package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.data.TaiKhoanRepo;
import web.model.TaiKhoan;

@Service
public class TaiKhoanSer {
	@Autowired
	private TaiKhoanRepo taikhoanRepo;
	
	public TaiKhoan addTk(TaiKhoan tk) {
		return taikhoanRepo.save(tk);
	}
}
