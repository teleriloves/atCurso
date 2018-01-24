package com.example.demo.service;

public class CalcServiceImpl implements CalcService
{

	@Override
	public Integer suma(Integer a, Integer b) {
		return a+b;
	}

	@Override
	public Integer mult(Integer a, Integer b) {
		Integer res = 0;
		for(int i = 0; i<a; ++i)
		{
			res = suma(res,b);
		}
		
		return res;
	}

}
