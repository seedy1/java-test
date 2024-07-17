package com.test.jobejavamatawansolution.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "team")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String position;

    @JsonIgnoreProperties("player")
    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;
}
