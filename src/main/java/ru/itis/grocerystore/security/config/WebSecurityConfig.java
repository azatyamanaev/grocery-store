package ru.itis.grocerystore.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import ru.itis.grocerystore.security.authentication.JwtAuthentication;
import ru.itis.grocerystore.security.filter.JwtAuthenticationFilter;
import ru.itis.grocerystore.services.UserService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.csrf().disable();
//        http.antMatcher("*").anonymous();
//
//        http.authorizeRequests()
//                .antMatchers("/user/updatePassword** ",
//                        "/user/savePassword** ",
//                        "/updatePassword** ")
//                .hasAuthority("CHANGE__PASSWORD__PRIVILEGE");
//
//        http.authorizeRequests()
//                .antMatchers("/signIn", "/signUp", "/")
//                .permitAll()
//                .antMatchers("/profile/*")
//                .authenticated();
//
////        http.authorizeRequests().antMatchers("/").permitAll();
//
//        http.formLogin()
//                .loginPage("/signIn")
//                .usernameParameter("login")
//                .defaultSuccessUrl("/profile") //TODO: need to do exclusive page for each role
//                .failureUrl("/signIn")
//                .permitAll();
//
//        http.logout()
//                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//                .logoutSuccessUrl("/signIn")
//                .deleteCookies("JSESSIONID");
        http.csrf().disable();
        http.sessionManagement().disable();
        http.addFilterBefore(new JwtAuthenticationFilter(), BasicAuthenticationFilter.class);
        http.authorizeRequests().antMatchers("/").permitAll();
    }
}
