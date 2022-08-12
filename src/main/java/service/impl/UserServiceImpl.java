package service.impl;

import entities.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import repository.UserRepository;
import service.UserService;

import java.util.Optional;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User findByUsername(String username) {
        User user;
        user = userRepository.findByUsername(username);
        return user;
    }

    @Override
    public User findById(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElse(null);
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }
}
