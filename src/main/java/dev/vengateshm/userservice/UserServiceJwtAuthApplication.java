package dev.vengateshm.userservice;

import dev.vengateshm.userservice.domain.Role;
import dev.vengateshm.userservice.domain.User;
import dev.vengateshm.userservice.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class UserServiceJwtAuthApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserServiceJwtAuthApplication.class, args);
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // Run only once after spring application is initialized
    // If multiple commandline runners does different job then
    // ordering can be specified using @Order(1), @Order(2)
    @Bean
    CommandLineRunner commandLineRunner(UserService userService) {
        return args -> {
            userService.saveRole(new Role(null, "ROLE_USER"));
            userService.saveRole(new Role(null, "ROLE_MANAGER"));
            userService.saveRole(new Role(null, "ROLE_ADMIN"));
            userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

            userService.saveUser(new User(null, "John Doe", "john", "1234", new ArrayList<>()));
            userService.saveUser(new User(null, "Bob Jones", "bob", "1234", new ArrayList<>()));
            userService.saveUser(new User(null, "Chris Jordan", "chris", "1234", new ArrayList<>()));
            userService.saveUser(new User(null, "Justin Kemp", "justin", "1234", new ArrayList<>()));

            userService.assignRoleToUser("john", "ROLE_USER");
            userService.assignRoleToUser("john", "ROLE_MANAGER");
            userService.assignRoleToUser("bob", "ROLE_MANAGER");
            userService.assignRoleToUser("chris", "ROLE_ADMIN");
            userService.assignRoleToUser("justin", "ROLE_SUPER_ADMIN");
            userService.assignRoleToUser("justin", "ROLE_ADMIN");
            userService.assignRoleToUser("justin", "ROLE_USER");
        };
    }
}
