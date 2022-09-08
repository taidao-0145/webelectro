package web.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import web.model.Wish;

public interface WishRepo  extends JpaRepository<Wish, Long>{
	List<Wish> findByUsername(String username);
}
