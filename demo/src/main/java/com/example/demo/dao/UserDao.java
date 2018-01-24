package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.User;


															
public interface UserDao extends PagingAndSortingRepository<User, Integer>{

	
	public List<User> findByName(@Param(value = "name") String name);
//	
//	//Recupera el usuario si alguno de sus libros tiene title
//	@Query(value = "select u from user as u INNER JOIN u.books as b where b.title like :title and u.id like :id")
//	public List<User> findUserBooksLike(@Param(value = "idUser") Integer idUser,
//										@Param(value = "title") String title);

	
}
