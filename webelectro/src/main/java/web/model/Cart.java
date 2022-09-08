package web.model;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@Entity
@Table(name = "cart")
public class Cart {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String username;
	private Long idproduct;
	private String tensp;
	private String img;	
	private int gia;
	private int num;
	private int tong;
	
	public Cart( String username, Long idproduct, String tensp, String img, int gia, int num, int tong) {
		
		
		this.username = username;
		this.idproduct = idproduct;
		this.tensp = tensp;
		this.img = img;
		this.gia = gia;
		this.num = num;
		this.tong = tong;
	}
	
	
}
