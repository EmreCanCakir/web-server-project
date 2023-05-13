package edu.estu.webserver.dataaccess;

import edu.estu.webserver.entities.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectDao extends JpaRepository<Subject, Integer> {
}