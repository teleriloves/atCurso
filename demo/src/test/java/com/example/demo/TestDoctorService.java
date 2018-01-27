package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.dozer.DozerBeanMapper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.example.demo.dao.DoctorDao;
import com.example.demo.dto.DoctorDTO;
import com.example.demo.exceptions.NotFoundExcept;
import com.example.demo.model.Doctor;
import com.example.demo.service.doctor.DoctorService;
import com.example.demo.service.doctor.DoctorServiceImpl;



@RunWith(MockitoJUnitRunner.class)
public class TestDoctorService {
	
	private static Integer ID = 123;
	private static String NAME = "Juan Ramon";
	private static String DNI = "12345678A";
	private static Doctor DOCTOR = new Doctor();
		
	@InjectMocks
	private DoctorService doctorService = new DoctorServiceImpl();
	
	@Mock
	private DoctorDao doctorDao;
	
	@Before
	public void init()
	{
		DOCTOR.setIdDoc(ID);
		DOCTOR.setName(NAME);
		
		Mockito.when(doctorDao.findById(ID)).thenReturn(DOCTOR);
	}
	
	@Test 
	public void testFindDoctorOk() throws NotFoundExcept
	{
			
		final DoctorDTO d = doctorService.findById(123);
		
		Assert.assertNotNull(d);
		Assert.assertEquals(NAME,d.getName());
		Assert.assertEquals(DNI,d.getDni());		
	}

	@Test(expected = NotFoundExcept.class)
	public void testDoctorNotFound() throws NotFoundExcept
	{
		doctorService.findById(999);
	}
	
}
