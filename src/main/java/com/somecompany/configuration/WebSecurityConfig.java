package com.somecompany.configuration;

import com.somecompany.filter.ContentTraceFilter;
import com.somecompany.filter.PrincipalTraceFilter;
import org.springframework.boot.actuate.web.trace.servlet.HttpTraceFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.context.SecurityContextPersistenceFilter;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private HttpTraceFilter httpTraceFilter;
    private ContentTraceFilter contentTraceFilter;
    private PrincipalTraceFilter principalTraceFilter;

    public WebSecurityConfig(HttpTraceFilter httpTraceFilter, ContentTraceFilter contentTraceFilter, PrincipalTraceFilter principalTraceFilter) {
        this.httpTraceFilter = httpTraceFilter;
        this.contentTraceFilter = contentTraceFilter;
        this.principalTraceFilter = principalTraceFilter;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.addFilterBefore(contentTraceFilter, SecurityContextPersistenceFilter.class)
                .addFilterAfter(httpTraceFilter, SecurityContextPersistenceFilter.class)
                .addFilterAfter(principalTraceFilter, FilterSecurityInterceptor.class)
                .cors()
                .and()
                	.authorizeRequests()
                		.antMatchers("/", "/error", "/webjars/**", "/actuator/**")
                			.permitAll()
                		.anyRequest()
                			.authenticated()
                .and()
                	.oauth2ResourceServer()
                		.jwt();
    }
}
