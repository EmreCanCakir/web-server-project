package edu.estu.webserver.api;

import edu.estu.webserver.business.abstracts.SubjectService;
import edu.estu.webserver.core.utilities.constants.CONSTANTS;
import edu.estu.webserver.entities.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/subjects")
public class SubjectController {

    private final SubjectService subjectService;

    @Autowired
    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @GetMapping("")
    public ResponseEntity<?> getAll() {
        return CONSTANTS.getResponseEntity(subjectService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable int id) {
        return CONSTANTS.getResponseEntity(subjectService.getById(id));
    }

    @PostMapping("")
    public ResponseEntity<?> add(@RequestBody Subject subject) {
        return CONSTANTS.getResponseEntity(subjectService.add(subject));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable int id, @RequestBody Subject subject) {
        return CONSTANTS.getResponseEntity(subjectService.update(subject));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        return CONSTANTS.getResponseEntity(subjectService.delete(id));
    }
}

