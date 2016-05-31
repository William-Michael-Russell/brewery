package net.testaholic.brewery.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests().antMatchers("/greeting/**").permitAll();
//        http.authorizeRequests().antMatchers("/index.html").permitAll();
        http.authorizeRequests().antMatchers("/*.css").permitAll();
//        http.authorizeRequests().antMatchers("/resources/static/**").permitAll();
//        http.authorizeRequests().antMatchers("/resources/**").permitAll();
        http.authorizeRequests().antMatchers("/static/**").permitAll();

//        http.authorizeRequests().antMatchers("/resources/**").permitAll();
//        http.authorizeRequests().antMatchers("/**").permitAll();
//        http.authorizeRequests().antMatchers("**").permitAll();
//        http.authorizeRequests().antMatchers("findme.txt").permitAll();
//        http.authorizeRequests().antMatchers("/findme.txt").permitAll();
//        http.authorizeRequests().antMatchers("/public/**").permitAll();
//
//        http.authorizeRequests().anyRequest().permitAll();
        http.authorizeRequests()
                .antMatchers("/", "/public/**").permitAll()
                .antMatchers("/user/update").permitAll()
                //allow
                .antMatchers("/drinks").permitAll()
                .antMatchers("/user/create").permitAll()
                .antMatchers("/contact").permitAll()
                .antMatchers("/location/**").permitAll()
                .antMatchers("/appetizers").permitAll()
                .antMatchers("/users/**").permitAll()
                .anyRequest().fullyAuthenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .failureUrl("/login?error")
                .usernameParameter("email")
                .permitAll()
                .and()
                .logout()
                .logoutUrl("/logout")
                .deleteCookies("remember-me")
                .logoutSuccessUrl("/")
                .permitAll()
                .and()
                .rememberMe();
//        http
//                .authorizeRequests()
//                .anyRequest().permitAll();
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userDetailsService)
                .passwordEncoder(new BCryptPasswordEncoder());

    }

//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth
//                .inMemoryAuthentication()
//                .withUser("demo@localhost.com").password("demo").roles("ADMIN");
//    }

}