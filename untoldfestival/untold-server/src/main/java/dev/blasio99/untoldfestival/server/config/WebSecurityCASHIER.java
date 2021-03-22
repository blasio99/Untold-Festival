// package dev.blasio99.untoldfestival.server.config;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.core.annotation.Order;
// import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
// import org.springframework.security.core.userdetails.UserDetailsService;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

// import dev.blasio99.untoldfestival.server.enums.Roles;

// @Configuration
// @Order(1)
// public class WebSecurityCASHIER extends WebSecurityConfigurerAdapter {
// 	@Autowired
// 	BCryptPasswordEncoder bCryptPasswordEncoder;
	
// 	@Autowired
// 	UserDetailsService adminDetailsServiceImpl;
	
// 	@Override
// 	public void configure(AuthenticationManagerBuilder auth) throws Exception {
// 		auth.userDetailsService(adminDetailsServiceImpl).passwordEncoder(bCryptPasswordEncoder);
// 	}

// 	@Override
// 	public void configure(HttpSecurity http) throws Exception {
// 		http
// 			.authorizeRequests()
// 			.antMatchers("/**").hasRole(Roles.CASHIER.name())
// 			.anyRequest().authenticated()
// 			.and().formLogin()//.loginPage("/admin/login")
// 				.defaultSuccessUrl("http://127.0.0.1:5500/untoldfestival/untold-site/src/untold/cashier/index.html", true)
// 				//.failureUrl("/admin/accessdenied")
// 			.permitAll();
// 			//.and().logout().logoutUrl("/admin/logout").logoutSuccessUrl("/admin/login")
// 			//.and().exceptionHandling().accessDeniedPage("/admin/accessdenied");
// 		http.cors().and().csrf().disable();
// 	}
// }