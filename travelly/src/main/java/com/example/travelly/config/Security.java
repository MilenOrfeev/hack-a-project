package com.example.travelly.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

@Configuration
@EnableWebSecurity
public class Security extends WebSecurityConfigurerAdapter {

    public static final String ADMIN_ROLE = "ADMINISTRATOR";
    public static final String EVENT_ATENDEE_ROLE = "EVENT_ATENDEE";
    public static final String EVENT_ORGANISER_ROLE = "EVENT_ORGANISER";



    // List the mappings/methods for which no authorisation is required.
    // By default we allow all GETs and full access to the H2 console.
    private static final RequestMatcher[] NO_AUTH = { new AntPathRequestMatcher("/**", "GET"),
            new AntPathRequestMatcher("/h2-console/**"),  new AntPathRequestMatcher("/connect/twitter", "POST")};

    private static final RequestMatcher[] EVENT_ORGANISER_AUTH = { new AntPathRequestMatcher("/**", "GET"),
            new AntPathRequestMatcher("/h2-console/**"),  new AntPathRequestMatcher("/connect/twitter", "POST"),
            new AntPathRequestMatcher("/events", "POST"), new AntPathRequestMatcher("/events/deleteByID/**", "DELETE"),
            new AntPathRequestMatcher("/events/update", "POST"), new AntPathRequestMatcher("/venues/deleteByID/**", "DELETE"),
            new AntPathRequestMatcher("/venues/updateVenue", "POST"), new AntPathRequestMatcher("/venues/", "POST")};

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // By default, all requests are authenticated except our specific list.
        http.authorizeRequests().requestMatchers(NO_AUTH).permitAll().anyRequest().hasRole(ADMIN_ROLE);
        http.authorizeRequests().requestMatchers(NO_AUTH).permitAll().anyRequest().hasRole(EVENT_ATENDEE_ROLE);
        http.authorizeRequests().requestMatchers(EVENT_ORGANISER_AUTH ).permitAll().anyRequest()
                .hasRole(EVENT_ORGANISER_ROLE);

        // Use form login/logout for the Web.
        http.formLogin().loginPage("/sign-in").permitAll().defaultSuccessUrl("/events", true);
        http.logout().logoutUrl("/sign-out").logoutSuccessUrl("/").permitAll();

        // Use HTTP basic for the API.
        http.requestMatcher(new AntPathRequestMatcher("/api/**")).httpBasic();

        // Only use CSRF for Web requests.
        // Disable CSRF for the API and H2 console.
        http.antMatcher("/**").csrf().ignoringAntMatchers("/api/**", "/h2-console/**");

        // Disable X-Frame-Options for the H2 console.
        http.headers().frameOptions().disable();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("Rob").password("Haines").roles(ADMIN_ROLE);
        auth.inMemoryAuthentication().withUser("Caroline").password("Jay").roles(EVENT_ATENDEE_ROLE);
        auth.inMemoryAuthentication().withUser("Markel").password("Vigo").roles(EVENT_ORGANISER_ROLE);
        auth.inMemoryAuthentication().withUser("A").password("B").roles(EVENT_ORGANISER_ROLE);
    }
}
