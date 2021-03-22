package dev.blasio99.untoldfestival.server.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {


	@Autowired
 	BCryptPasswordEncoder bCryptPasswordEncoder;
	
    @Autowired
	private UserDetailsService userDetailsService;

	@Autowired
    @Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
	}

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors()
			.and ()
			.csrf().disable()
            .authorizeRequests()
			.antMatchers("/**").permitAll()
			//.antMatchers("/api/concert/genre/**").permitAll()
			//.antMatchers("/api/concert/all").permitAll()
			//.antMatchers("/admin/api/cashiers").permitAll()
            //.antMatchers("/api/**").hasAnyRole(String.valueOf("CASHIER"), String.valueOf("ADMIN"))
            //.antMatchers("/admin/api/**").hasRole(String.valueOf("ADMIN"))
            .anyRequest()
            .authenticated()
            .and()
            .httpBasic();
    }

    /*@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}*/

    
}


/*@Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
            .authorizeRequests()
			//.antMatchers("/login").permitAll()
			.antMatchers("/api/concert/genre/**").permitAll()
			.antMatchers("/api/concert/all").permitAll()
			.antMatchers("/admin/api/cashiers").permitAll()
            //.antMatchers("/api/**").hasAnyRole(String.valueOf("CASHIER"), String.valueOf("ADMIN"))
            .antMatchers("/admin/api/**").hasRole(String.valueOf("ADMIN"))
            .anyRequest()
            .authenticated()
            .and()
			.formLogin()
			.
			.defaultSuccessUrl("http://127.0.0.1:5500/untoldfestival/untold-site/src/untold/index.html", true)
                .permitAll(); 
    }*/
