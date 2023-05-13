package edu.estu.webserver.dataaccess;

import edu.estu.webserver.entities.Program;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProgramDao extends JpaRepository<Program, Integer> {
}
