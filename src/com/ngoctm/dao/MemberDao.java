package com.ngoctm.dao;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

@Component
public class MemberDao {
	
	public void addAccount() {
		
		System.out.println(getClass() + " add member account");
	}
	
	public String getFotuner() throws Throwable{
		
		try {
			TimeUnit.SECONDS.sleep(5);
		
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (true) {
			throw new RuntimeException("loi tu tao");
		}
		
		return "ahihi";
	}
	
	
	public void doWork() {
		
		System.out.println(getClass() + " do work member dao");
	}

}
