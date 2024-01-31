package com.chai.schoolApp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ProjectSecurityConfig {
	
	
	@Bean
	SecurityFilterChain security(HttpSecurity http) throws Exception{

		
		http.csrf((csrf->csrf.ignoringRequestMatchers("/saveMsg")))		
		.authorizeHttpRequests((requests)->requests
				.requestMatchers("/dashboard").authenticated()
				.requestMatchers("/","home").permitAll()
				.requestMatchers("/courses").permitAll()
				.requestMatchers("/contact").permitAll()
				.requestMatchers("/saveMsg").permitAll()
				.requestMatchers("/holidays/**").permitAll()
				.requestMatchers("/about").permitAll()
				.requestMatchers("/assets/**").permitAll()
				.requestMatchers("/login").permitAll()
				.requestMatchers("/logout").permitAll())
		.formLogin(loginConfigurer->loginConfigurer.loginPage("/login")
				.defaultSuccessUrl("/dashboard")
				.failureUrl("/login?error=true").permitAll())
		.logout(logoutConfigurer->logoutConfigurer.logoutSuccessUrl("/login?logout=true")
				.invalidateHttpSession(true).permitAll())
		.httpBasic(Customizer.withDefaults());	
		return http.build();
		
	}

@Bean
public InMemoryUserDetailsManager userDetailsService() {
	
	@SuppressWarnings("deprecation")
	UserDetails user =User.withDefaultPasswordEncoder()
			.username("user").password("123456").roles("USER").build();
	
	@SuppressWarnings("deprecation")
	UserDetails admin =User.withDefaultPasswordEncoder()
			.username("admin").password("654321").roles("USER","ADMIN").build();
		
	return new InMemoryUserDetailsManager(user,admin);
	
}
}
