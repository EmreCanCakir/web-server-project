package edu.estu.webserver.dataaccess;

import edu.estu.webserver.entities.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberDao extends JpaRepository<Member, Integer> {
}
