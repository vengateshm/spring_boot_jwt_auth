package dev.vengateshm.userservice.controller;

import dev.vengateshm.userservice.domain.Role;
import dev.vengateshm.userservice.domain.User;
import dev.vengateshm.userservice.request.RoleToUserRequest;
import dev.vengateshm.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class UserController {
    private final UserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.ok().body(userService.getUsers());
    }

    @PostMapping("/user/save")
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/api/save/user").toUriString());

        return ResponseEntity.created(uri).body(userService.saveUser(user));
    }

    @PostMapping("/role/save")
    public ResponseEntity<Role> saveRole(@RequestBody Role role) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/api/save/role").toUriString());
        return ResponseEntity.created(uri).body(userService.saveRole(role));
    }

    @PostMapping("/role/assignToUser")
    public ResponseEntity<?> assignRoleToUser(@RequestBody RoleToUserRequest roleToUserRequest) {
        userService.assignRoleToUser(roleToUserRequest.getUsername(), roleToUserRequest.getRoleName());
        return ResponseEntity.ok().build();
    }
}
