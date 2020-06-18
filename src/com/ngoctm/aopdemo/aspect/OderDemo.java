package com.ngoctm.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class OderDemo {

	@Before("com.ngoctm.aopdemo.aspect.MyDemoLogin.noGetterSetter()")
	public void beforeAdd() {
		System.out.println("=======> executing before bla bla");
	}
}
