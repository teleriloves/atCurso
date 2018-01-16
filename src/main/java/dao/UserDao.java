package dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import model.User;


															//Saber de que trata
public interface UserDao extends PagingAndSortingRepository<User, Integer>{

	//@Query(value = "from User u where u.name like :name")
	//Según el dialecto Spring hara una búsqueda u otra, por ejemplo, findByName
	public List<User> findByName(String name/*@Param ...*/);
	
}
