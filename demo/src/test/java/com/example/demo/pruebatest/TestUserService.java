package com.example.demo.pruebatest;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.example.demo.dao.UserDao;
import com.example.demo.dto.UserDTO;
import com.example.demo.exceptions.NotFoundExcept;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import com.example.demo.service.UserServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class TestUserService {
	
	static final Integer ID = 1;
	static final String NAME = "k6";
	
	@InjectMocks
	private UserService userService = new UserServiceImpl();
	
	@Mock
	private UserDao userDao;
	
	public void mapToUserBaseExists()
	{
		Mockito.when(userDao.exists(ID)).thenReturn(Boolean.TRUE);
		final User user = userMockAuto();
		Mockito.when(userDao.findOne(ID)).thenReturn(user);
		
		final UserDTO userDto = new UserDTO();
	}
	
	public User userMockAuto()
	{
		final User user = new User();
		user.setId(ID);
		user.setName(NAME);
		return user;
	}
	
	public void mapToUserBaseNotExists()
	{
		Mockito.when(userDao.exists(ID)).thenReturn(Boolean.FALSE);
	}
	
	
	
	
	
	
	
	
	
	
//	@InjectMocks
//	private UserService service = new UserServiceImpl();
//	
//	@Mock
//	private UserDao dao;
//	
//	@Test
//	public void testFindByIdCase()
//	{
//		final User user = new User();
//		final String name = "K6";
//		user.setName(name);
//		Mockito.when(dao.findOne(8)).thenReturn(user);
//		
//		final User res = service.findById(8);
//		Assert.assertNotNull(res);
//		Assert.assertEquals(name, res.getName());
//		
//	}
//	
//	@Test(expected = NotFoundExcept.class)
//	public void testFindByIdNotFound() throws NotFoundExcept
//	{
//		service.findById(999);
//	}

}
