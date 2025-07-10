package org.generations.eoi.springsecuritydemo.config;


import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;


import java.util.List;


public class CustomAuthenticationProvider implements AuthenticationProvider {

    private final ExternalAuthService externalAuthService;

    public CustomAuthenticationProvider(ExternalAuthService externalAuthService) {
        this.externalAuthService = externalAuthService;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();

        boolean autorizado = externalAuthService.authenticateRandomly(username, password);

        if (autorizado) {
            return new UsernamePasswordAuthenticationToken(
                    username, password, List.of(new SimpleGrantedAuthority("ROLE_USER"))
            );
        } else {
            throw new BadCredentialsException("Acceso denegado por autenticación aleatoria");
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }
}
