package com.app.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
@Configuration
@ComponentScan(basePackages="com.app")
public class AppConfig {

	@Bean
	public JavaMailSender mail() {
		JavaMailSenderImpl impl=new JavaMailSenderImpl();
		impl.setHost("smtp.gmail.com");
		impl.setPort(587);
		impl.setUsername("ssovan35@gmail.com");
		impl.setPassword("2704199526");
		impl.setJavaMailProperties(prop());
		return impl;
	}
	
	private Properties prop() {
		Properties properties=new Properties();
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		return properties;
	}
}
