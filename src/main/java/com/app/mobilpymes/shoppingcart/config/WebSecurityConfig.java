package com.app.mobilpymes.shoppingcart.config;


import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;


@EnableWebSecurity
public
class WebSecurityConfig extends WebSecurityConfigurerAdapter implements WebMvcConfigurer {

    @Override
    protected
    void configure (HttpSecurity http) throws Exception {
        http.cors ( ).and ( );
        http.csrf ( ).disable ( );
        //other config
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource ( ) {
        CorsConfiguration configuration = new CorsConfiguration ( );
        configuration.setAllowedOrigins ( Arrays.asList ( "https://main.d2mnbsq68cet5d.amplifyapp.com", "https://calm-rock-0d0c8e20f.1.azurestaticapps.net" ) );
        configuration.setAllowedMethods ( Arrays.asList ( "GET", "POST", "PUT" ) );
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource ( );
        source.registerCorsConfiguration ( "/**", configuration );
        return source;
    }

    @Override
    public
    void addCorsMappings (CorsRegistry registry) {
        registry.addMapping ( "/**" ).allowedMethods ( "*" );
    }
}

