package edu.estu.webserver.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "members")
@PrimaryKeyJoinColumn(name = "member_id", referencedColumnName = "id")
public class Member extends User {
    @Column(name = "age")
    private String age;

    @Column(name = "height")
    private String height;

    @Column(name = "weight")
    private String weight;

    @Column(name = "is_active")
    private boolean isActive;

    @Column(name = "is_deleted")
    private boolean isDeleted;

    @Column(name = "membership_start_at")
    private LocalDateTime membershipStartAt;

    @Column(name = "expired_at")
    private LocalDateTime expiredAt;

}
