package com.example.employeemgmtsecurity.config;

import com.example.employeemgmtsecurity.service.teacherservice.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {
    //for using jpa
    @Autowired
    private UserInfoService userInfoService;
    //here UserDetailsService is the predefined datatype
    //authentication
  /*
  @Bean
   public UserDetailsService userDetailsService(){
        *//*UserDetails admin= User.builder()
                        .username("admin")
                .password(encoder.encode("admin123"))
                .roles("ADMIN")
                .build();
        UserDetails user=User.builder()
                .username("user")
                .password(encoder.encode("user123"))
                .roles("USER")
                .build();

        //store these user in InMemory
        return new InMemoryUserDetailsManager(admin,user);*//*
    }*/
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity ) throws Exception {
       return httpSecurity.csrf().disable()
               .userDetailsService(userInfoService)

              /* for  inmemory
               .authorizeHttpRequests()
               //getById userley matra
                .requestMatchers("/api/v1/teacher/{teacher_id:\\d+}").hasRole("ADMIN")
               //getAll admin ley matra
               .requestMatchers("/api/v1/teacher").hasRole("USER")
               .requestMatchers("/addNewUser").permitAll()

                //aru sab admin ley entine payo user ley ne payo
               .anyRequest()
                .authenticated()

                .and()

               */

               .formLogin()

                .and()
               .httpBasic().
               and().build();
    }

    @Bean
    //its not  good to store password in plantext so we use PasswordEncoder to encode the password
    public static PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
