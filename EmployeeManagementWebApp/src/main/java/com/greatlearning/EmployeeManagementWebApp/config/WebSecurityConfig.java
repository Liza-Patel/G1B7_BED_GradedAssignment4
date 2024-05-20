package com.greatlearning.EmployeeManagementWebApp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.greatlearning.EmployeeManagementWebApp.service.FetchedDecoratedUser;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(authorizeRequests -> authorizeRequests
				.requestMatchers("/getEmployeeById/**", "/getEmployees", "/updateEmployee/**", "/deleteEmployeeById/**",
						"/getEmployeeByFirstName/**", "/getSortedEmployees/**")
				.hasAnyAuthority("USER", "ADMIN").requestMatchers("/addEmployee").hasAuthority("ADMIN")
				.requestMatchers("/addRole", "/addUser").permitAll().anyRequest().authenticated())
				.formLogin(formLogin -> formLogin.loginProcessingUrl("/login").defaultSuccessUrl("/greet", true)
						.permitAll())
				.logout(logout -> logout.logoutSuccessUrl("/login").permitAll())
				.exceptionHandling(exceptionHandling -> exceptionHandling.accessDeniedPage("/unauthorized"))
				.httpBasic(Customizer.withDefaults()).cors(Customizer.withDefaults()).csrf(csrf -> csrf.disable());

		http.authenticationProvider(myAuthenticationProvider());

		return http.build();
	}

	@Bean
	public AuthenticationProvider myAuthenticationProvider() {
		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
		daoAuthenticationProvider.setUserDetailsService(myUserDetailsService());
		daoAuthenticationProvider.setPasswordEncoder(myPasswordEncoder());
		return daoAuthenticationProvider;
	}

	@Bean
	public PasswordEncoder myPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public UserDetailsService myUserDetailsService() {
		return new FetchedDecoratedUser();
	}
}
