package com.example.match_odds_api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Match_Odds")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MatchOdds {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String specifier;

    @Column(nullable = false)
    private Double odd;

    @ManyToOne
    @JoinColumn(name = "match_id", nullable = false)
    @JsonIgnore
    private Match match;
}
