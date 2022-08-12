package service;

import entities.User;

public interface UserService {
    User findByUsername(String username);
    User findById(Long id);
    User createUser(User user);
}
