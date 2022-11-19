package com.example.authenticatingldap;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//public class WebSecurityConfig implements WebMvcConfigurer {

	//@Override
	//public void addViewControllers(ViewControllerRegistry registry) {
	//	registry.addViewController("/login")
	//			.setViewName("login");
	//}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//http
		//	.authorizeRequests()
		//		.anyRequest().fullyAuthenticated()
		//		.and()
		//	.formLogin();

		//http
		//	.authorizeRequests()
		//		.anyRequest().fullyAuthenticated()
		//		.and()
		//	.formLogin().
		//		loginPage("/login");
		//http
		//		.formLogin()
		//		.loginPage("/login.html");

		http.authorizeRequests().antMatchers(
						"/registration**",
						"/js/**",
						"/css/**",
						"/img/**").permitAll()
				.anyRequest().authenticated()
				.and()
				.formLogin()
				.loginPage("/login")
				.permitAll()
				.and()
				.logout()
				.invalidateHttpSession(true)
				.clearAuthentication(true)
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
				.logoutSuccessUrl("/login?logout")
				.permitAll();
	}

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
			.ldapAuthentication()
				.userDnPatterns("uid={0},ou=people")
				.groupSearchBase("ou=groups")
				.contextSource()
					.url("ldap://localhost:8389/dc=springframework,dc=org")
					.and()
				.passwordCompare()
					.passwordEncoder(new BCryptPasswordEncoder())
					.passwordAttribute("userPassword");
	}

}
