/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ni.edu.ucem.webapi.auth;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author mgarciaf
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true )
public class ConfigSeguridad extends WebSecurityConfigurerAdapter{
    
    private final DataSource dataSource;
    
    @Autowired
    public ConfigSeguridad(final DataSource dataSource)
    {
        this.dataSource = dataSource;
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
             .antMatchers(HttpMethod.GET).permitAll()
             .antMatchers(HttpMethod.POST).hasAnyRole("ADMIN")
             .antMatchers(HttpMethod.DELETE).hasAnyRole("ADMIN")
             .antMatchers(HttpMethod.PUT).hasAnyRole("ADMIN")
             .anyRequest().authenticated()
        .and()
             .httpBasic()
        .and()
             .sessionManagement()
             .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        .and()
             .csrf().disable();
    }
    
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception
    {
        auth.jdbcAuthentication().dataSource(dataSource)
        .passwordEncoder(new BCryptPasswordEncoder(10))
        .usersByUsernameQuery(
                "select username, password, enabled from usuarios where username = ?")
        .authoritiesByUsernameQuery(
                "select username, role from usuarios_roles where username = ?");
    }
}
