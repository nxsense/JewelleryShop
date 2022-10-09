package service.impl;

import entities.Role;
import entities.User;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import repository.RoleRepository;
import repository.UserRepository;
import service.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
/**
 * Implementation of userService interface, where interaction with database for users is described
 *
 * @author author
 * @version 1.0
 */
@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    /**
     * Finding a certain user by its username
     * @param username of the user we want to find
     * @return some user
     */
    @Override
    public User findByUsername(String username) {
        User user;
        user = userRepository.findByUsername(username);
        return user;
    }

    /**
     * Searching for a certain user by id
     *
     * @param id of the user we search
     */
    @Override
    public User findById(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElse(null);
    }

    /**
     * Method for creating new user
     * @param user
     */
    @Override
    public void createUser(User user) {
        Role role = roleRepository.findByName("ROLE_USER");
        List<Role> userRoles = new ArrayList<>();
        userRoles.add(role);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(userRoles);
        userRepository.save(user);
    }
}
