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
// @Order(2)
// public class WebSecurityADMIN extends WebSecurityConfigurerAdapter {
// 	@Autowired
// 	BCryptPasswordEncoder bCryptPasswordEncoder;
	
// 	@Autowired
// 	UserDetailsService userDetailsServiceImpl;
	
// 	@Override
// 	public void configure(AuthenticationManagerBuilder auth) throws Exception {
// 		auth.userDetailsService(userDetailsServiceImpl).passwordEncoder(bCryptPasswordEncoder);
// 	}

// 	@Override
// 	public void configure(HttpSecurity http) throws Exception {
// 		http
// 			.authorizeRequests()
// 			.antMatchers("/**").hasRole(Roles.ADMIN.name())
// 			.anyRequest().authenticated()
// 			.and().formLogin()//.loginPage("/login")
// 				.defaultSuccessUrl("http://127.0.0.1:5500/untoldfestival/untold-site/src/untold/admin/index.html", true)
// 				//.failureUrl("/accessdenied")
// 			.permitAll();
// 			//.and().logout().logoutSuccessUrl("/login");
		
// 		http.cors().and().csrf().disable();
// 	}
// }	