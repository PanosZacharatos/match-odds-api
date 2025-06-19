package com.example.match_odds_api.model;

import com.example.match_odds_api.enums.SportType;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name = "Match")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private LocalDate match_date;

    @Column(nullable = false)
    private LocalTime match_time;

    @Column(nullable = false)
    private String team_a;

    @Column(nullable = false)
    private String team_b;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private SportType sport;

    @OneToMany(mappedBy = "match", cascade = CascadeType.ALL)
    private List<MatchOdds> matchOdds;

}
