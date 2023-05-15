package edu.estu.webserver.api;

import edu.estu.webserver.business.abstracts.AdminService;
import edu.estu.webserver.core.utilities.constants.CONSTANTS;
import edu.estu.webserver.entities.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admins")
public class AdminController {
    private final AdminService adminService;
    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("")
    public ResponseEntity<?> getAll() {
        return CONSTANTS.getResponseEntity(this.adminService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable int id) {
        return CONSTANTS.getResponseEntity(this.adminService.getById(id));
    }

    @PostMapping("")
    public ResponseEntity<?> add(@RequestBody Admin admin) {
        return CONSTANTS.getResponseEntity(this.adminService.add(admin));
    }

    @PutMapping("")
    public ResponseEntity<?> update(@RequestBody Admin admin) {
        return CONSTANTS.getResponseEntity(this.adminService.update(admin));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        return CONSTANTS.getResponseEntity(this.adminService.delete(id));
    }
}