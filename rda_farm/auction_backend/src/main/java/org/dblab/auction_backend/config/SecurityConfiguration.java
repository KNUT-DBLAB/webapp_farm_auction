package org.dblab.auction_backend.config;

import lombok.RequiredArgsConstructor;

import org.dblab.auction_backend.service.CustomUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@RequiredArgsConstructor
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final JwtTokenProvider jwtTokenProvider;
    private final CustomUserDetailsService customUserDetailsService;

    @Bean
    public PasswordEncoder passwordEncoder()
    {
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .httpBasic().disable()
                // rest api이므로 기본설정 안함. 기본설정은 비인증 시 로그인 폼 화면으로 리다이렉트 된다.
                .cors()
                .and()
                .csrf().disable()
                // rest api 이므로 csrf 보안이 필요 없음. disable
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                // jwt token으로 생성하므로 세션은 필요 없으므로 생성 안함.
                .and()
                    .authorizeRequests() // 다음 리퀘스트에 대한 사용권한 체크
                        .antMatchers("/**").permitAll()
                        // .antMatchers("/", "/login","/test/**", "/api/signupConsumer", "/api/signupFarmMember", "/api/login", "/api/existEmail", "/socket").permitAll()
                        .anyRequest().hasRole("USER")
                .and()
                    .addFilterBefore(new JwtAuthenticationFilter(jwtTokenProvider),
                            UsernamePasswordAuthenticationFilter.class);
                            // jwt token 필터를 id/password 인증 필터 전에 넣는다.
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override 
    public void configure(WebSecurity web) {
        web.ignoring().antMatchers("/", "/product_images/**", "/user_profile_images/**");
    }
}