package edu.estu.webserver.dataaccess;

import edu.estu.webserver.entities.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainerDao extends JpaRepository<Trainer, Integer> {
}