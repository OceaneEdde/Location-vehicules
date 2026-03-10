package com.accenture.applicationlocationvehicule.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity

public class SecurityConfig {


    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .httpBasic(Customizer.withDefaults())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(
                                "/v3/api-docs/**",
                                "/swagger-ui/**",
                                "/swagger-ui.html"
                        ).permitAll()


                        // Administrateurs
                        .requestMatchers(HttpMethod.POST, "/administrators/**").permitAll()
                        .requestMatchers("/administrators/**").hasRole("ADMIN")

                        // Clients
                        .requestMatchers(HttpMethod.POST, "/clients/**").permitAll()
                        .requestMatchers("/clients/**").hasRole("ADMIN")


                        // Cars
                        .requestMatchers(HttpMethod.GET, "/cars/**").permitAll()
                        .requestMatchers(HttpMethod.POST, "/cars/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PATCH, "/cars/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/cars/**").hasRole("ADMIN")


                        // Bikes
                        .requestMatchers(HttpMethod.GET, "/bikes/**").permitAll()
                        .requestMatchers(HttpMethod.POST, "/bikes/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PATCH, "/bikes/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/bikes/**").hasRole("ADMIN")


                        // Motorcycles
                        .requestMatchers(HttpMethod.GET, "/motorcycles/**").permitAll()
                        .requestMatchers(HttpMethod.POST, "/motorcycles/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PATCH, "/motorcycles/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/motorcycles/**").hasRole("ADMIN")


                        // Motorhomes
                        .requestMatchers(HttpMethod.GET, "/motorhomes/**").permitAll()
                        .requestMatchers(HttpMethod.POST, "/motorhomes/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PATCH, "/motorhomes/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/motorhomes/**").hasRole("ADMIN")


                        // Trucks
                        .requestMatchers(HttpMethod.GET, "/trucks/**").permitAll()
                        .requestMatchers(HttpMethod.POST, "/trucks/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PATCH, "/trucks/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/trucks/**").hasRole("ADMIN")


                        .anyRequest().authenticated()

                );
        return http.build();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Bean(name = "customUserDetailsManager")
    UserDetailsManager userDetailsManager(DataSource dataSource) {
        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
        jdbcUserDetailsManager.setUsersByUsernameQuery("select email, password, 1 from user_loggin where email = ?");
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery("select email, CONCAT ('ROLE_', roles) as roles from user_loggin where email = ?");
        return jdbcUserDetailsManager;
    }


}
