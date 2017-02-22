package com.personalcoach.configuration;

import com.personalcoach.model.enams.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;


@Configuration
@EnableWebMvcSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    // Устанавливаем ограничения на URL
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .authorizeRequests()
                .antMatchers("/coach/**").hasAuthority(UserRole.ROLE_COACH.name())
                .antMatchers("/client/**").hasAuthority(UserRole.ROLE_CLIENT.name())
                .anyRequest().permitAll()
                .and()
                .formLogin()
                .loginPage("/loginpage")
                .loginProcessingUrl("/login")
                .usernameParameter("username")
                .passwordParameter("password")
                .defaultSuccessUrl("/")
                .failureUrl("/404")
                .and()
                .logout()
                .logoutSuccessUrl("/")

                .and().csrf().disable(); // temporarily
    }

    // Устанавливаем, где брать пользователей
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

}
