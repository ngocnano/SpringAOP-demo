package com.ngoctm.aopdemo;

import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ngoctm.aopdemo.aspect.MyDemoLogin;
import com.ngoctm.dao.AccountDAO;
import com.ngoctm.dao.MemberDao;

public class MainDemoApp {
	
	public static Logger myLogger = Logger.getLogger(MyDemoLogin.class.getName());
	
	public static void main(String[] args) {
		
		// read spring config class
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConfigClass.class);
		
		// get bean from spring container
		AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
		MemberDao memberDao = context.getBean("memberDao", MemberDao.class);
		
		accountDAO.setIdString("2245");
		accountDAO.setPassString("ngocnano1998");
		// call business method
	//	accountDAO.addAccount();
		
		//memberDao.addAccount();
		
	//	memberDao.doWork();
		
		//accountDAO.setAccount();
		//try {
			//accountDAO.findAcc();
			
			
		//} catch (Exception e) {
			// TODO: handle exception
			//myLogger.info("exception " + e);
		//}
		
		String data = memberDao.getFotuner();
		myLogger.info(data);
		
		// close spring context
		context.close();
	}

}
