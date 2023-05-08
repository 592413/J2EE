package com.myc.spring.aspect;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class Audience {

	@Before("execution(* com.myc.spring.aspect.Performance.perform(..))")
	public void silenceCellPhones() {
		System.out.println("Silencing cell phones");
	}
	
	@Before("execution(* com.myc.spring.aspect.Performance.perform(..))")
	public void takeSeats() {
		System.out.println("Taking Seats");
	}
	
	@AfterReturning("execution(* com.myc.spring.aspect.Performance.perform(..))")
	public void appluase() {
		System.out.println("CLAP CLAP CLAP");
	}
	
	@AfterThrowing("execution(* com.myc.spring.aspect.Performance.perform(..))")
	public void demandRefund() {
		System.out.println("Demanding a refund");
	}
	
}
