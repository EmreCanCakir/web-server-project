package edu.estu.webserver.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "subjects")
public class Subject {
    @Id
    @Column(name = "subject_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int subjectId;

    @Column(name = "title")
    private String title;

    @Column(name = "day")
    private String day;

    @Column(name = "hour")
    private String hour;

    @ManyToMany
    @JoinTable(name = "program_subjects",
            joinColumns = @JoinColumn(name = "program_id"),
            inverseJoinColumns = @JoinColumn(name = "subject_id"))
    private List<Program> programs;
}
