package security;

import entities.User;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import repository.UserRepository;
import security.JwtUserDetails;

@AllArgsConstructor
public class JwtUserDetailsService implements UserDetailsService {
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = this.userRepository.findByUsername(username);
        JwtUserDetails jwtUser = JwtUserFactory.create(user);
        return jwtUser;
    }
}
