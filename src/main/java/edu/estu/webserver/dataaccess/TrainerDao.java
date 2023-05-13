package edu.estu.webserver.dataaccess;

import edu.estu.webserver.entities.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TrainerDao extends JpaRepository<Trainer, Integer> {
    Optional<Trainer> findByUserName(String userName);
}