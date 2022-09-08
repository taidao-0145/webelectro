package web.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@Entity
public class Wish {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String username;
	private String tensp;
	private int gia;
	private int soluong;
	private String img;
	
	
	public Wish( String username, String tensp, int gia, int soluong, String img) {
		
	
		this.username = username;
		this.tensp = tensp;
		this.gia = gia;
		this.soluong = soluong;
		this.img = img;
	}
	
	
}
