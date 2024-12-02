package com.rubypaper.board.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(security -> security.requestMatchers("/board/**").authenticated()
				.requestMatchers("/admin/**").hasRole("ADMIN").anyRequest().permitAll());
		http.csrf(cf -> cf.disable());

		http.formLogin(form -> form.loginPage("/system/login").defaultSuccessUrl("/board/getBoardList", true));

		http.logout(logout -> logout.invalidateHttpSession(true).deleteCookies("JSESSIONID")
				.logoutSuccessUrl("/system/login"));

		http.headers(hr -> hr.frameOptions(fo -> fo.disable()));

		http.exceptionHandling(ex -> ex.accessDeniedPage("/system/accessDenied"));

		return http.build();
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
