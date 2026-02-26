package fi.haagahelia.bookstore.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class WebSecurityConfig {
@Bean
public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
}
@Bean
public SecurityFilterChain configure(HttpSecurity http) throws Exception {
    http
        .authorizeHttpRequests( authorize -> authorize
            .requestMatchers("/", "/home", "/css/**", "/js/**").permitAll()
            .requestMatchers("/edit/**", "/delete/**", "/add/**").hasRole("ADMIN")
            .anyRequest().authenticated()
        )
        .formLogin( formlogin -> formlogin
            .loginPage("/login")
            .defaultSuccessUrl("/booklist", true)
            .permitAll()
        )
        .logout( logout -> logout
            .permitAll()
        );
        return http.build();
    }
@Bean
public UserDetailsService userDetailsService() {
    UserDetails user = User.builder()
        .username("user")
        .password(passwordEncoder().encode("user"))
        .roles("USER")
        .build();

    UserDetails admin = User.builder()
        .username("ADMIN")
        .password(passwordEncoder().encode("ADMIN"))
        .roles("ADMIN")
        .build();

    return new InMemoryUserDetailsManager(user, admin);
}
}