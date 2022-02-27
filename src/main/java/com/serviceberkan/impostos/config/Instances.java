package com.serviceberkan.impostos.config;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.serviceberkan.impostos.domain.Salary;
import com.serviceberkan.impostos.domain.User;
import com.serviceberkan.impostos.dto.UserDTO;
import com.serviceberkan.impostos.repository.SalaryRepository;
import com.serviceberkan.impostos.repository.UserRepository;

@Configuration
public class Instances implements CommandLineRunner {

	private static final String Double = null;

	@Autowired
	private UserRepository repo;

	@Autowired
	private SalaryRepository Salaryrepo;

	@Override
	public void run(String... args) throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

		repo.deleteAll();
		Salaryrepo.deleteAll();

		User u1 = new User(null, "Wagner D.S", "wagner@gmail.com");
		User u2 = new User(null, "Anna Laker", "annalaker@gmail.com");
		User u3 = new User(null, "GAbriel Laker D", "gabriellaker@gmail.com");
		repo.saveAll(Arrays.asList(u1, u2, u3));

		Salary fevU1 = new Salary(null, Calc(1000.00, 0), sdf.parse("26/02/2022"), new UserDTO(u1));
		Salary marU1 = new Salary(null, Calc(3000.00, 2), sdf.parse("26/03/2022"), new UserDTO(u1));
		Salary fevU3 = new Salary(null, Calc(6000.00, 0), sdf.parse("26/02/2022"), new UserDTO(u3));
		Salaryrepo.saveAll(Arrays.asList(fevU1, marU1, fevU3));
		
		u1.getSalary().addAll(Arrays.asList(fevU1,marU1));
		repo.save(u1);
		u3.getSalary().addAll(Arrays.asList(fevU3));
		repo.save(u3);
		
	}

	
	/*Função auxiliar*/
	private String Calc(Double sal, Integer dependentes) {
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

		return format(salario);

	}

	private static String format(Double valor) {
		return new DecimalFormat("R$ " + "#,##0.00").format(valor);
	}

}
