package com.serviceberkan.impostos.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import com.serviceberkan.impostos.dto.UserDTO;
import com.serviceberkan.impostos.service.ImpostoRef;

public class Salary implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String id;
	private Double salaryDefault;
	private ImpostoRef salary;
	private Date date;
	private UserDTO user;
	
	public Salary() {	}
	
	public Salary(String id, Double salaryDefault, ImpostoRef imposto, Date date, UserDTO user) {
		super();
		this.id = id;
		this.salaryDefault = salaryDefault;
		this.salary = imposto;
		this.date = date;
		this.user = user;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public ImpostoRef getSalary() {
		return salary;
	}

	public void setSalary(ImpostoRef salary) {
		this.salary = salary;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	public Double getSalaryDefault() {
		return salaryDefault;
	}

	public void setSalaryDefault(Double salaryDefault) {
		this.salaryDefault = salaryDefault;
	}

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Salary other = (Salary) obj;
		return Objects.equals(id, other.id);
	}
	
	

	
}
