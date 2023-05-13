package edu.estu.webserver.dataaccess;

import edu.estu.webserver.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Integer> {
}