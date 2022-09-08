package web.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import web.model.Cart;



public interface CartRepo extends JpaRepository<Cart, Long>{
	List<Cart> findByUsername(String username);

	
	@Query(value="SELECT * FROM cart where username=? and idproduct=?", nativeQuery=true) 
	List<Cart> checkcart(String username,Long id);
	
	@Transactional
	@Modifying
	@Query(value="UPDATE cart set num=num+1 ,tong=tong+gia where username=? and idproduct=?", nativeQuery=true) 
	void updatecheck(String username,Long id);
	
	@Transactional
	@Modifying
	@Query(value="UPDATE cart set num=num+1 ,tong=tong+gia where id=? ", nativeQuery=true) 
	void numplus(Long id);
	
	@Transactional
	@Modifying
	@Query(value="UPDATE cart set num=num-1 ,tong=tong-gia where id=? ", nativeQuery=true) 
	void numminus(Long id);
	
}
