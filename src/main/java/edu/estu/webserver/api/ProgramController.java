package edu.estu.webserver.api;

import edu.estu.webserver.business.abstracts.ProgramService;
import edu.estu.webserver.core.utilities.constants.CONSTANTS;
import edu.estu.webserver.entities.Program;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/programs")
public class ProgramController {

    private final ProgramService programService;

    @Autowired
    public ProgramController(ProgramService programService) {
        this.programService = programService;
    }

    @GetMapping("")
    public ResponseEntity<?> getAll() {
        return CONSTANTS.getResponseEntity(programService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable int id) {
        return CONSTANTS.getResponseEntity(programService.getById(id));
    }

    @PostMapping("")
    public ResponseEntity<?> add(@RequestBody Program program) {
        return CONSTANTS.getResponseEntity(programService.add(program));
    }

    @PutMapping("")
    public ResponseEntity<?> update(@RequestBody Program program) {
        return CONSTANTS.getResponseEntity(programService.update(program));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        return CONSTANTS.getResponseEntity(programService.delete(id));
    }
}
