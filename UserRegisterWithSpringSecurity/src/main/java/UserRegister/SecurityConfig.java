package UserRegister;

import UserRegister.filter.CsrfHeaderFilter;
import UserRegister.service.LoginStudentDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 * Created by kajiwarayutaka on 2015/06/30.
 */
@Configuration
@EnableWebMvcSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/js/**", "/lib/**", "/css/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/","/users/register").permitAll()
                .antMatchers("/users").hasRole("ADMIN")
                .anyRequest().authenticated();
        http.formLogin().loginPage("/").failureUrl("/?error")
                .usernameParameter("user").passwordParameter("password")
                .defaultSuccessUrl("/loginSuccess").and()
                .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout**"))
                .logoutSuccessUrl("/").and()
                .csrf().csrfTokenRepository(csrfTokenRepository()).and()
                .addFilterAfter(new CsrfHeaderFilter(), CsrfFilter.class);
    }

    @Configuration
    static class AuthenticationConfiguration extends
            GlobalAuthenticationConfigurerAdapter {
        @Autowired
        LoginStudentDetailService loginStudentDetailService;

        @Bean
        PasswordEncoder passwordEncoder() {
            return new BCryptPasswordEncoder();
        }


        @Override
        public void init(AuthenticationManagerBuilder auth) throws Exception {
            auth.userDetailsService(loginStudentDetailService).passwordEncoder(
                    passwordEncoder());
        }
    }

    private CsrfTokenRepository csrfTokenRepository() {
        HttpSessionCsrfTokenRepository repository = new HttpSessionCsrfTokenRepository();
        repository.setHeaderName("X-XSRF-TOKEN");
        return repository;
    }
}
