package com.serviceberkan.impostos.config;

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
import com.serviceberkan.impostos.service.ImpostoRef;

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
		
		ImpostoRef imposto = new ImpostoRef(null,1000.0, 0);
		ImpostoRef imposto2 = new ImpostoRef(null,3000.0, 2);
		ImpostoRef imposto3 = new ImpostoRef(null, 6000.0, 0);
		
		
		Salary fevU1 = new Salary(null, 1000.00, imposto, sdf.parse("26/02/2022"), new UserDTO(u1));
		Salary marU1 = new Salary(null, 3000.00, imposto2, sdf.parse("26/03/2022"), new UserDTO(u1));
		Salary fevU3 = new Salary(null, 6000.00, imposto3, sdf.parse("26/02/2022"), new UserDTO(u3));
		Salaryrepo.saveAll(Arrays.asList(fevU1, marU1, fevU3));
		
		u1.getSalary().addAll(Arrays.asList(fevU1,marU1));
		repo.save(u1);
		u3.getSalary().addAll(Arrays.asList(fevU3));
		repo.save(u3);
		
	}

	
	

}
