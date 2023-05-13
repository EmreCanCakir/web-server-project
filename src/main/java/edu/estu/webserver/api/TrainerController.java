package edu.estu.webserver.api;

import edu.estu.webserver.business.abstracts.TrainerService;
import edu.estu.webserver.core.utilities.constants.CONSTANTS;
import edu.estu.webserver.entities.Trainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/trainers")
public class TrainerController {
    private final TrainerService trainerService;

    @Autowired
    public TrainerController(TrainerService trainerService) {
        this.trainerService = trainerService;
    }

    @PostMapping
    public ResponseEntity<?> addTrainer(@RequestBody Trainer trainer) {
        return CONSTANTS.getResponseEntity(trainerService.add(trainer));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTrainer(@PathVariable int id) {
        return CONSTANTS.getResponseEntity(trainerService.delete(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateTrainer(@PathVariable int id, @RequestBody Trainer trainer) {
        return CONSTANTS.getResponseEntity(trainerService.update(trainer));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getTrainerById(@PathVariable int id) {
        return CONSTANTS.getResponseEntity(trainerService.getById(id));
    }

    @GetMapping
    public ResponseEntity<?> getAllTrainers() {
        return CONSTANTS.getResponseEntity(trainerService.getAll());
    }
}
