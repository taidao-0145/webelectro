package web.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import web.model.TaiKhoan;

@Repository
public interface TaiKhoanRepo extends JpaRepository<TaiKhoan, String>{
	List<TaiKhoan> findByUsernameAndPass(String username,String pass);
	List<TaiKhoan> findByUsername(String username);
	
	
}
