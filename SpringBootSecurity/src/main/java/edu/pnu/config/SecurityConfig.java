package edu.pnu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig { // 보안 설정 파일
	
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(security->security
				.requestMatchers("/member/**").authenticated() // 로그인을 한(인증을 받은)
				.requestMatchers("/manager/**").hasAnyRole("MANAGER","ADMIN")
				.requestMatchers("/admin/**").hasRole("ADMIN")
				.anyRequest().permitAll());
		
		http.csrf(cf->cf.disable());
		
		 // 기본 로그인 기능을 사용
		http.formLogin(form-> 
				form.loginPage("/login")
				.defaultSuccessUrl("/loginSuccess", true)
		);
		http.exceptionHandling(ex->ex.accessDeniedPage("/accessDenied"));
		
		http.logout(logout->logout
				.invalidateHttpSession(true)
				.deleteCookies("JSESSIONID")
				.logoutSuccessUrl("/login"));
		
		http.headers(hr->hr.frameOptions(fo->fo.disable()));
		return http.build();
	}
	
	// 패스워드를 다시 암호화
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
//	@Autowired
//	public void authenticate(AuthenticationManagerBuilder auth) throws Exception {
//		auth.inMemoryAuthentication()
//		.withUser("user")
//		.password("{noop}abcd")
//		.roles("USER");
//		
//		auth.inMemoryAuthentication()
//		.withUser("manager")
//		.password("{noop}abcd")
//		.roles("MANAGER");
//		
//		auth.inMemoryAuthentication()
//		.withUser("admin")
//		.password("{noop}abcd")
//		.roles("ADMIN");
//		
//		auth.inMemoryAuthentication()
//		.withUser("junyeoung")
//		.password("{noop}abcd")
//		.roles("ADMIN");
//	}

}
