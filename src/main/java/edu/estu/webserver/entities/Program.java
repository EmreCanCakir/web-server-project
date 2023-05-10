package edu.estu.webserver.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "programs")
public class Program {
    @Id
    @Column(name = "program_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "programs_id_generator")
    @SequenceGenerator(name = "programs_id_generator", sequenceName = "programs_id_seq", allocationSize = 1)
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "day")
    private String day;

    @Column(name = "hour")
    private String hour;

    @OneToOne(mappedBy = "programId")
    //@JsonIgnore
    private Trainer trainerId;
}
