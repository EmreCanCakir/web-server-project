package edu.estu.webserver.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "programs")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Program {
    @Id
    @Column(name = "program_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "day")
    private String day;

    @Column(name = "hour")
    private String hour;

    @OneToOne(mappedBy = "programId")
    @JsonIgnore
    private Trainer trainerId;

    @ManyToMany(mappedBy = "programs")
    private List<Subject> subjects;
}
