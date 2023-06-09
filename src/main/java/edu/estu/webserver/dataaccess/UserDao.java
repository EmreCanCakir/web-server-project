package edu.estu.webserver.dataaccess;

import edu.estu.webserver.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserDao extends JpaRepository<User, Integer> {
    Optional<User> findByUserName(String userName);
}