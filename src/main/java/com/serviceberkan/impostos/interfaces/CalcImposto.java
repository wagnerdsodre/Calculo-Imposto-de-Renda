package com.serviceberkan.impostos.interfaces;

import java.awt.font.NumericShaper.Range;

import com.serviceberkan.impostos.domain.Salary;

public interface CalcImposto {

	
	public static Double calc(Double sal, Integer dependentes) {
		
		Double inss1 = 1751.81;
				
		if (sal <= inss1) {
			Double alicota = 0.8;
			sal = sal - (sal * alicota);
			sal = sal - (dependentes*189.59);
			if(sal <= 1903.98) {
				return sal;
			}
			
			
		}else {
			return null;
		}
		
		
		
		return null;
			
	}
	
}
