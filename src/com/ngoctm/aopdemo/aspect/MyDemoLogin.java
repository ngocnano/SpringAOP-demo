package com.ngoctm.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLogin {
	
	
	@Pointcut("execution(* com.ngoctm.dao.*.*())")
	public void forDAOPackage() {}
	
	//add pointcut getter method
	@Pointcut("execution(* com.ngoctm.dao.*.get*())")
	public void getter() {}
	
	//add pointcut setter method
	@Pointcut("execution(* com.ngoctm.dao.*.set*())")
	public void setter() {}
	
	// combine pointcut
	@Pointcut("forDAOPackage() && !(getter() || setter())")
	public void noGetterSetter() {}


	@Pointcut("execution(* com.ngoctm.dao.*.find*())")
	public void find() {}
	

}
