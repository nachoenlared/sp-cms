package org.nelr.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import static org.springframework.security.web.header.writers.frameoptions.XFrameOptionsHeaderWriter.XFrameOptionsMode.SAMEORIGIN;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	CustomAuthenticationProvider customAuthenticationProvider;
	
	 @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(customAuthenticationProvider);
    }
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.csrf().disable()
			.headers().frameOptions().sameOrigin().and()
			.logout()
				.logoutUrl("/logout")
				.logoutSuccessUrl("/login")
				//.logoutSuccessHandler(logoutSuccessHandler)
				.invalidateHttpSession(true)
				//.addLogoutHandler(logoutHandler)
				//.deleteCookies(cookieNamesToClear)
				.and()
			.authorizeRequests()
				.antMatchers("/index").hasRole("USER")
				.antMatchers("/admin**").hasRole("ADMIN")
				.antMatchers("/h2/**").permitAll()
				.antMatchers("/statics/**").permitAll()
				.antMatchers("/register").permitAll()
				.anyRequest().authenticated()
				.and()
			.formLogin()
				.loginPage("/login")
				.permitAll()
				.and()			
			.httpBasic();
	}
}
