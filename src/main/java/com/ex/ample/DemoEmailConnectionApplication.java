package com.ex.ample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@SpringBootApplication
public class DemoEmailConnectionApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoEmailConnectionApplication.class, args);
	}

	@Bean
	public JavaMailSender emailSender(){
		return new JavaMailSenderImpl();
	}
}

