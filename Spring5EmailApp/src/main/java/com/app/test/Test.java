package com.app.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.io.FileSystemResource;

import com.app.config.AppConfig;
import com.app.util.AppMailSender;

public class Test {

	public static void main(String[] args) {
		ApplicationContext context=new AnnotationConfigApplicationContext(AppConfig.class);
		AppMailSender sender=context.getBean("appMailSender",AppMailSender.class);
		FileSystemResource fileSystemResource=new FileSystemResource("D:/unnamed.gif");
		boolean flag=sender.sendEmail("ssovan152@gmail.com", "Hello", "Welcome to Spring Email", fileSystemResource);
		if(flag) {
			System.out.println("Done...!!!");
		}else {
			System.out.println("Sorry...!!!!");
		}
	}
}
