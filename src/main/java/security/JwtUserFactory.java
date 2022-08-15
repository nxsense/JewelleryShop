package security;

import entities.Role;
import entities.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import security.JwtUserDetails;

import java.util.List;
import java.util.stream.Collectors;

public class JwtUserFactory {
    public JwtUserFactory() {
    }

    public static JwtUserDetails create (User user) {
        return new JwtUserDetails(
                user.getId(),
                user.getName(),
                user.getSurname(),
                user.getUsername(),
                user.getPassword(),
                user.getEmail(),
                null);
    }

    private static List<GrantedAuthority> mapToGrantedAuthorities(List<Role> userRoles) {
        return userRoles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());
    }
}
