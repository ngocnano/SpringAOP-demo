package com.ngoctm.aopdemo.aspect;

import java.util.logging.Logger;

import javax.sound.midi.Soundbank;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.aop.aspectj.AspectJAroundAdvice;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.ngoctm.dao.AccountDAO;

@Aspect
@Component
@Order(1)
public class Order2 {
	
	private static Logger myLogger = Logger.getLogger(MyDemoLogin.class.getName());
	
	@Around("execution(* com.ngoctm.dao.MemberDao.getFotuner())")
	public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		
		String method = proceedingJoinPoint.getSignature().toString();
		myLogger.info(method);
		
		long begin = System.currentTimeMillis();
		
		Object reObject = null;
		try {
			reObject = proceedingJoinPoint.proceed();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			System.out.println(e);
			reObject = "loi vai lon";
			throw e;
		}
		
		long end = System.currentTimeMillis();
		
		myLogger.info("time " + (end - begin));
		
		return reObject;
	}
	
	
	@After("com.ngoctm.aopdemo.aspect.MyDemoLogin.find()")
	public void afterA() {
		myLogger.info("run after advice");
	}
	
	@AfterThrowing(pointcut = "com.ngoctm.aopdemo.aspect.MyDemoLogin.find()", throwing = "ex")
	public void AfterThrowing(JoinPoint joinPoint, Throwable ex) {
		
		String method = joinPoint.getSignature().toShortString();
		
		myLogger.info(method);
		
		myLogger.info("Throw ex" + ex);
		
	}
	
	
	@AfterReturning(pointcut = "com.ngoctm.aopdemo.aspect.MyDemoLogin.find()", returning = "pass")
	public void afterReturnFindAcc(JoinPoint joinPoint, AccountDAO pass) {
		
		// Display method we are advicing on
		
		String method = joinPoint.getSignature().toShortString();
		
		myLogger.info(method);
		
		// Display return value
		
		myLogger.info(getClass() + " return value " + pass.getPassString());
		
		
		pass.setPassString("modifier");
				
	}

	@Before("com.ngoctm.aopdemo.aspect.MyDemoLogin.noGetterSetter()")
	public void beforeAdd2(JoinPoint jPoint) {
		myLogger.info("=======> executing before ble ble.....................");
	
	// display method signature
	MethodSignature methodSignature = (MethodSignature) jPoint.getSignature();
	myLogger.info("method signature" + methodSignature);
		
	
	// display argument 
	
	Object[] args = jPoint.getArgs();
	
	for(Object object : args) {
		
		if(object instanceof AccountDAO) {
			
			System.out.println(object);
			
		}
		
	}
	
	
	}
}
