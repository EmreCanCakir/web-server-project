package edu.estu.webserver.api;

import edu.estu.webserver.business.abstracts.MemberService;
import edu.estu.webserver.core.utilities.constants.CONSTANTS;
import edu.estu.webserver.entities.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/members")
public class MemberController {
    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }


    @GetMapping("")
    public ResponseEntity<?> getAll() {
        return CONSTANTS.getResponseEntity(memberService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable int id) {
        return CONSTANTS.getResponseEntity(memberService.getById(id));
    }

    @PostMapping("")
    public ResponseEntity<?> add(@RequestBody Member member) {
        return CONSTANTS.getResponseEntity(memberService.add(member));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable int id, @RequestBody Member member) {
        return CONSTANTS.getResponseEntity(memberService.update(member));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        return CONSTANTS.getResponseEntity(memberService.delete(id));
    }

}
