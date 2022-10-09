package service;

import entities.User;
/**
 * @author author
 * @version 1.0
 */
public interface UserService {
    User findByUsername(String username);
    User findById(Long id);
    void createUser(User user);
}
