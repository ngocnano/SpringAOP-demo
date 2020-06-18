package com.ngoctm.dao;

import org.springframework.stereotype.Component;

@Component
public class AccountDAO {
	
	private String idString;
	private String passString;
	
	public void addAccount() {
		
		System.out.println(getClass() + " Add account on DB");
	}
	
	public void setAccount() {
		
		System.out.println(getClass() + " set acount blabla");
	}

	public String getIdString() {
		return idString;
	}

	public void setIdString(String idString) {
		this.idString = idString;
	}

	public String getPassString() {
		return passString;
	}

	public void setPassString(String passString) {
		this.passString = passString;
	}
	
	public AccountDAO findAcc() {
		
		
		
		AccountDAO accountDAO = new AccountDAO();
		
		accountDAO.idString = this.idString;
		accountDAO.passString = this.passString;
		
		if(idString != null) {
			
			throw new RuntimeException("Ex ba la");
			}
		
		return accountDAO;
	}
	
	
}
