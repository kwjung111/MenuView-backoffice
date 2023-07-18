package backoffice.backoffice.config;

import backoffice.backoffice.security.CustomAuthenticationSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity //spring security 설정 활성
public class SecurityConfig {

    @Autowired
    AuthenticationSuccessHandler CustomAuthenticationSuccessHandler;

    @Autowired
    AuthenticationFailureHandler CustomAuthenticationFailureHandler;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        //Http security 설정

        http
                .csrf(csrf -> csrf
                        .disable())
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/**").permitAll()
                        .requestMatchers("/main").hasRole("USER")
                        .anyRequest().authenticated()
                )   //설정은 위에서부터 적용됨

                .formLogin(formLogin ->formLogin
                        .loginPage("/login").permitAll()
                        .loginProcessingUrl("/loginproc")  //credential validation url
                        .failureUrl("/?error=true")
                        .usernameParameter("username")
                        .passwordParameter("password")
                        .successHandler(CustomAuthenticationSuccessHandler)
                        .failureHandler(CustomAuthenticationFailureHandler)
                )
                .logout(Customizer.withDefaults());        //기본설정(/logout 으로 인증해제)
                //.rememberMe(Customizer.withDefaults());

        return http.build();
    }



}
