package edu.estu.webserver.dataaccess;

import edu.estu.webserver.entities.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminDao extends JpaRepository<Admin, Integer> {
}
