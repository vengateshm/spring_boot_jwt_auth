package dev.vengateshm.userservice.service;

import dev.vengateshm.userservice.domain.Role;
import dev.vengateshm.userservice.domain.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);

    Role saveRole(Role role);

    void assignRoleToUser(String username, String roleName);

    User getUser(String username);

    List<User> getUsers();// Real world paged user list. Inefficient to load all users
}
