package com.example.authenticatingldap;

import com.example.authenticatingldap.core.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSender;

@SpringBootApplication
//public class AuthenticatingLdapApplication extends SpringBootServletInitializer {
public class AuthenticatingLdapApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthenticatingLdapApplication.class, args);
	}

	@Bean
	TokenStore tokenStore () {
		return new InMemoryTokenStore();
	}

	@Bean
	Sender sender (JavaMailSender aJavaMailSender) {
		return new EmailSender(aJavaMailSender);
	}

	@Bean
	Authenticator authenticator () {
		return new SpringSecurityAuthenicator(tokenStore());
	}


}
