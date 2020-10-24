package com.tiny.ecommerce.TinyEcommerce.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.web.bind.annotation.CrossOrigin;

@Configuration
@EnableResourceServer
@CrossOrigin(origins = "http://localhost:4200")
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

//	.cors().disable()
//    .authorizeRequests()
//	.antMatchers( HttpMethod.OPTIONS, "/**")
//	.permitAll().and()
	
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
            .headers()
                .frameOptions()
                .disable()
                .and()
            .authorizeRequests()
                .antMatchers("/","/home","/register","/login").permitAll()
                .antMatchers("/private/users/createUser").permitAll()
                .antMatchers("/private/**").authenticated()
                .and()
        	.sessionManagement()
        		.maximumSessions(300).sessionRegistry(sessionRegistry());
    }
    
    @Bean
    public SessionRegistry sessionRegistry() {
        return new SessionRegistryImpl();
    }


}
