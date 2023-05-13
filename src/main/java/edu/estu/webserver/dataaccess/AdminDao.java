package edu.estu.webserver.dataaccess;

import edu.estu.webserver.entities.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminDao extends JpaRepository<Admin, Integer> {
    Optional<Admin> findByUserName(String userName);
}
