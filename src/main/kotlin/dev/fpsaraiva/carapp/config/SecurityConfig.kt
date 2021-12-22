package dev.fpsaraiva.carapp.config

import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.core.userdetails.User

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(jsr250Enabled = true)
class SecurityConfig: WebSecurityConfigurerAdapter()  {

    override fun configure(http: HttpSecurity) {
        http.csrf().disable()

        http.sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)

        http
            .authorizeRequests()
            .anyRequest()
            .authenticated()
            .and()
            .httpBasic()
    }

    override fun configure(auth: AuthenticationManagerBuilder) {
        val password = "{noop}password"

        val driver = User.builder()
            .username("driver")
            .password(password)
            .roles("DRIVER")

        val passenger = User.builder()
            .username("passenger")
            .password(password)
            .roles("PASSENGER")

        val admin = User.builder()
            .username("admin")
            .password(password)
            .roles("ADMIN")

        auth.inMemoryAuthentication()
            .withUser(driver)
            .withUser(passenger)
            .withUser(admin)
    }
}