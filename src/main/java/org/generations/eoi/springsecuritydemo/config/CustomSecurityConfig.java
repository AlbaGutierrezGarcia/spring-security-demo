package org.generations.eoi.springsecuritydemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class CustomSecurityConfig {

    private final ExternalAuthService externalAuthService;

    public CustomSecurityConfig(ExternalAuthService externalAuthService) {
        this.externalAuthService = externalAuthService;
    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorize ->
                        authorize.anyRequest().authenticated()
                )
                .authenticationProvider(customAuthenticationProvider())
                .formLogin(Customizer.withDefaults());
        return http.build();
    }
    @Bean
    public AuthenticationProvider customAuthenticationProvider() {
        return new CustomAuthenticationProvider(externalAuthService);
    }
}
