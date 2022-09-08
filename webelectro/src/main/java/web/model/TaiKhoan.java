package web.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
import lombok.RequiredArgsConstructor;


@Data
@RequiredArgsConstructor
@Entity

public class TaiKhoan {
	@Id
	private String username;
	private String email;
	private int phone;
	private String pass;
	private String img;
}
