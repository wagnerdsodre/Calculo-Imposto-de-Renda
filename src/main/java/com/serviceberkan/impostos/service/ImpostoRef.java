package com.serviceberkan.impostos.service;

import java.io.Serializable;
import java.text.DecimalFormat;

import org.springframework.stereotype.Service;

@Service
public class ImpostoRef implements Serializable {
		
	private static final long serialVersionUID = 1L;
	
	private String id;
	private Double sal;
	private Integer dependentes;
	
	public ImpostoRef() {
		
	}
			
	public ImpostoRef(String id, Double sal, Integer dependentes) {
		this.id = id;
		this.sal = sal;
		this.dependentes = dependentes;
	}

		
	
	public String getSal() {
		
		Double salario = 0.0;
		Double salfixo = sal;

		if (salfixo <= 1751.81) {
			salfixo = salfixo - (sal * 0.08);
			salfixo = salfixo - (dependentes * 189.59);
			if (salfixo <= 1903.98) {
				return format(salfixo);
			}

		} else if (salfixo >= 1751.82 && salfixo <= 2919.72) {
			Double baseMenosInss = sal - (sal * 0.09);
			Double baseMenosDep = baseMenosInss - (dependentes * 189.59);
			Double alicota = 0.0;
			Double deducao = 0.0;
			if (baseMenosDep >= 1903.99 && baseMenosDep <= 2826.65) {
				alicota = 0.075;
				deducao = 142.80;
			} else if (baseMenosDep >= 2826.66 && baseMenosDep <= 3751.05) {
				alicota = 0.15;
				deducao = 354.80;
			} else if (baseMenosDep >= 3751.06 && baseMenosDep <= 4664.68) {
				alicota = 0.22;
				deducao = 636.13;
			} else {
				alicota = 0.275;
				deducao = 636.13;
			}

			Double descontosAlicota = baseMenosDep * alicota;
			Double comDeducao = descontosAlicota - deducao;
			salario = sal - (comDeducao + (sal * 0.11));
			return format(salario);

		} else if (salfixo >= 2919.73 && salfixo <= 5839.45) {
			Double baseMenosInss = sal - (sal * 0.11);
			Double baseMenosDep = baseMenosInss - (dependentes * 189.59);
			Double alicota = 0.0;
			Double deducao = 0.0;
			if (baseMenosDep >= 1903.99 && baseMenosDep <= 2826.65) {
				alicota = 0.075;
				deducao = 142.80;
			} else if (baseMenosDep >= 2826.66 && baseMenosDep <= 3751.05) {
				alicota = 0.15;
				deducao = 354.80;
			} else if (baseMenosDep >= 3751.06 && baseMenosDep <= 4664.68) {
				alicota = 0.22;
				deducao = 636.13;
			} else {
				alicota = 0.275;
				deducao = 636.13;
			}

			Double descontosAlicota = baseMenosDep * alicota;
			Double comDeducao = descontosAlicota - deducao;
			salario = sal - (comDeducao + (sal * 0.11));
			return format(salario);

		}

		else {

			Double baseMenosInss = sal - 642.34;
			Double baseMenosDep = baseMenosInss - (dependentes * 189.59);

			Double alicota = 0.275;
			Double deducao = 869.36;

			Double descontosAlicota = baseMenosDep * alicota;
			Double comDeducao = descontosAlicota - deducao;
			salario = sal - (comDeducao + 642.34);
			return format(salario);

		}

		return format(sal);
	}
		
	
	public void setSal(Double sal) {
		this.sal = sal;
	}

	public Integer getDependentes() {
		return dependentes;
	}

	public void setDependentes(Integer dependentes) {
		this.dependentes = dependentes;
	}

		
	private static String format(Double valor) {
		return new DecimalFormat("R$ " + "#,##0.00").format(valor);
	}
	
	
}
