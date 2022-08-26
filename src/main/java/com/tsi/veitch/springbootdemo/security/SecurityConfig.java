package com.tsi.veitch.springbootdemo.security;

import com.auth0.spring.security.api.JwtWebSecurityConfigurer;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import java.util.Arrays;


@Configuration
@EnableWebSecurity()//debug = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Value("${auth0.audience}")
    private String apiAudience;
    @Value("${spring.security.oauth2.resourceserver.jwt.issuer-uri}")
    private String issuer;

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
        configuration.setAllowedMethods(Arrays.asList("GET","POST","PATCH","DELETE"));
        configuration.setAllowCredentials(true);
        configuration.addAllowedHeader("Authorization");
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors();
        JwtWebSecurityConfigurer
                .forRS256(apiAudience, issuer)
                .configure(http)
                .authorizeRequests()

                // Note: If passing an Authorization header, Spring Security will validate it even with permitAll()
                // You can ignore security filters if this is an issue for you, as discussed here:
                // https://stackoverflow.com/questions/36296869/spring-security-permitall-still-considering-token-passed-in-authorization-header
                .antMatchers(HttpMethod.GET, "/Sakila/film").permitAll()
                .antMatchers(HttpMethod.GET, "/Sakila/actor").permitAll()
                .antMatchers(HttpMethod.POST, "/Sakila/admin").hasAuthority("write:actors")
                .antMatchers(HttpMethod.PATCH, "/Sakila/admin").hasAuthority("write:actors")
                .antMatchers(HttpMethod.DELETE, "/Sakila/admin").hasAuthority("write:actors");
    }

}