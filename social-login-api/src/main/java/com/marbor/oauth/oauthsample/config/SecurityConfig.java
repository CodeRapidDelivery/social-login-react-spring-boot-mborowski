package com.marbor.oauth.oauthsample.config;

import com.marbor.oauth.oauthsample.security.Oauth2AuthenticationProvider;
import com.marbor.oauth.oauthsample.security.Oauth2AuthenticationFilter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.web.filter.CorsFilter;

import static com.marbor.oauth.oauthsample.controllers.routes.Routes.IS_AUTHENTICATED_ROUTE;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@Slf4j
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final CorsFilter corsFilter;
    private final Oauth2AuthenticationProvider oauth2AuthenticationProvider;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //@formatter:off
        http
            .csrf()
            .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
        .and()
            .addFilterAfter(corsFilter, CsrfFilter.class)
            .addFilterBefore(new Oauth2AuthenticationFilter(authenticationManager()), FilterSecurityInterceptor.class)
            .authorizeRequests()
            .antMatchers(IS_AUTHENTICATED_ROUTE).permitAll()
            .anyRequest().authenticated()
        .and()
            .logout()
            .logoutSuccessHandler(getLogoutHandler());
        //@formatter:on
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(oauth2AuthenticationProvider);
    }

    private LogoutSuccessHandler getLogoutHandler() {
        return (request, response, authentication) -> log.debug("{} logged out", authentication.getName());
    }
}
