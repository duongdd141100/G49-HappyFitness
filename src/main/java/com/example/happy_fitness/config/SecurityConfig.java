package com.example.happy_fitness.config;

import com.example.happy_fitness.constants.RequestMappingConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig {
    @Autowired
    private SignInAuthFilter signInAuthFilter;

    @Autowired
    private JWTAuthFilter jwtAuthFilter;

    @Autowired
    private FilterExceptionHandler filterExceptionHandler;
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .cors().and().csrf().disable()
                .addFilterBefore(signInAuthFilter, BasicAuthenticationFilter.class)
                .addFilterBefore(jwtAuthFilter, SignInAuthFilter.class)
                .addFilterBefore(filterExceptionHandler, JWTAuthFilter.class)
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeHttpRequests(request -> {
                    request.requestMatchers(HttpMethod.POST,
                                    RequestMappingConstant.SIGN_IN,
                                    RequestMappingConstant.SIGN_UP,
                                    RequestMappingConstant.FORGET_PASSWORD).permitAll()
                            .requestMatchers(HttpMethod.GET,
                                    RequestMappingConstant.GET_PRODUCT,
                                    RequestMappingConstant.FIND_TICKET,
                                    RequestMappingConstant.FIND_TICKET_DETAIL,
                                    RequestMappingConstant.FIND_VOUCHERS,
                                    RequestMappingConstant.IMAGE,
                                    RequestMappingConstant.FIND_FACILITY,
                                    RequestMappingConstant.FIND_CATEGORY,
                                    RequestMappingConstant.FIND_SUPPLIER,
                                    RequestMappingConstant.FIND_TRAIN_TIME,
                                    RequestMappingConstant.FIND_PACKAGE,
                                    "/vnpay_jsp/vnpay_return.jsp",
                                    "/api/payment/info").permitAll()
                            .anyRequest().authenticated();
                });
        return http.build();
    }
}
