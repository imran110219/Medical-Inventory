//package com.sadman.medicalinventory.configuration;
//
//import com.sadman.medicalinventory.service.CustomUserDetailsService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//@Configuration
//@EnableWebSecurity
//public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {
//
//    @Autowired
//    private CustomUserDetailsService userDetailsService;
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth
//                .userDetailsService(userDetailsService)
//                .passwordEncoder(passwordEncoder());
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//
//        http
//                .httpBasic()
//                .and()
//                .authorizeRequests()
//                .antMatchers("/api/brands/**").hasRole("ADMIN")
//                .antMatchers("/api/companies/**").hasRole("ADMIN")
//                .antMatchers("/api/generics/**").hasRole("ADMIN")
//                .antMatchers("/api/indications/**").hasRole("ADMIN")
//                .antMatchers("/api/indicationgenerics/**").hasRole("ADMIN")
//                .antMatchers("/api/invoices/**").hasRole("ADMIN")
//                .antMatchers("/api/roles/**").hasRole("ADMIN")
//                .antMatchers("/api/sales/**").hasRole("ADMIN")
//                .antMatchers("/api/users/**").hasRole("ADMIN")
//
//                .and()
//                .csrf().disable()
//                .formLogin().disable();
//    }
//
//
//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        web
//                .ignoring()
//                .antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**");
//    }
//
//}
