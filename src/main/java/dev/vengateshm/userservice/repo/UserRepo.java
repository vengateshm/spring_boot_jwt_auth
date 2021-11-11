package dev.vengateshm.userservice.repo;

import dev.vengateshm.userservice.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsername(String username);// Spring Data JPA interprets and find the user
}
