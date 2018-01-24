package com.example.demo.pruebatest;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.example.demo.service.CalcService;


@RunWith(MockitoJUnitRunner.class)
public class CursoTest {

	private CalcService calcService;
	
	@Test
	public void suma()
	{
		final Integer suma = calcService.suma(2,4);
		Assert.assertEquals(suma, Integer.valueOf(6));
	}
	
	@Test
	public void mult()
	{
		Mockito.when(calcService.suma(8, 8));
		
		final Integer mult = calcService.mult(2,8);
		Assert.assertEquals(mult, Integer.valueOf(16));
	}
	
}
