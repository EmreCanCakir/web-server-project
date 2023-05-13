package edu.estu.webserver.dataaccess;

import edu.estu.webserver.entities.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberDao extends JpaRepository<Member, Integer> {
    Optional<Member> findByUserName(String userName);
}
