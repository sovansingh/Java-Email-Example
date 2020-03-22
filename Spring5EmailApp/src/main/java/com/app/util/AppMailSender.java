package com.app.util;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component("appMailSender")
public class AppMailSender {

	@Autowired
	private JavaMailSender mailSender;
	
	public boolean sendEmail(String to,String sub,String text,FileSystemResource resource) {
		boolean status=false;
		try {
			MimeMessage message=mailSender.createMimeMessage();
			MimeMessageHelper helper=new MimeMessageHelper(message,resource!=null?true:false);
			helper.setTo(to);
			helper.setFrom("ssovan35@gmail.com");
			helper.setSubject(sub);
			helper.setText(text);
			helper.addAttachment(resource.getFilename(), resource);
			mailSender.send(message);
			status=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
}
