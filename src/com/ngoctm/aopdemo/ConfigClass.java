package com.ngoctm.aopdemo;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan("com.ngoctm.dao")
@ComponentScan("com.ngoctm.aopdemo")
public class ConfigClass {

}
