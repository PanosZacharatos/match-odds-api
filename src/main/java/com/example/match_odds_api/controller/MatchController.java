package com.example.match_odds_api.controller;

import com.example.match_odds_api.model.Match;
import com.example.match_odds_api.service.MatchService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/matches")
public class MatchController {
    private final MatchService matchService;

    public MatchController(MatchService matchService){
        this.matchService = matchService;
    }

    @GetMapping
    public ResponseEntity<List<Match>> getAllMatches(){
        return ResponseEntity.ok(matchService.getAllMatches());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Match> getMatchById(@PathVariable Long id){
        return ResponseEntity.ok(matchService.getMatchById(id));
    }

    @PostMapping
    public ResponseEntity<Match> createMatch(@RequestBody Match match){
        return ResponseEntity.ok(matchService.createMatch(match));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Match> updateMatch(@RequestBody Match updatedMatch,@PathVariable Long id){
        return ResponseEntity.ok(matchService.updateMatch(updatedMatch,id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMatch(@PathVariable Long id){
        matchService.deleteMatch(id);
        return ResponseEntity.noContent().build();
    }

}
