package com.myc.spring.webmvc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.myc.spring.aspect.Audience;

@Configuration
@EnableAspectJAutoProxy
public class AspectConfig {

	@Bean
	public Audience audience() {
		return new Audience();
	}
}
