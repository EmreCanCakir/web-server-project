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
@Table(name = "trainers")
@PrimaryKeyJoinColumn(name = "trainer_id", referencedColumnName = "id")
public class Trainer extends User {
    @Column(name = "is_active")
    private boolean isActive;

    @Column(name = "membership_start_at")
    private LocalDateTime membershipStartAt;

    @Column(name = "expired_at")
    private LocalDateTime expiredAt;

    @OneToOne
    @JoinColumn(name = "program_id", referencedColumnName = "program_id")
    private Program programId;
}
