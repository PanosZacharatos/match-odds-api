package com.example.match_odds_api.controller;

import com.example.match_odds_api.model.MatchOdds;
import com.example.match_odds_api.service.MatchOddsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/matchodds")
public class MatchOddsController {
    private final MatchOddsService matchOddsService;

    public MatchOddsController(MatchOddsService matchOddsService){
        this.matchOddsService = matchOddsService;
    }

    @GetMapping
    public ResponseEntity<List<MatchOdds>> getAllMatchOdds(){
        return ResponseEntity.ok(matchOddsService.getAllMatchOdds());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MatchOdds> getMatchOddsById(@PathVariable Long id){
        return ResponseEntity.ok(matchOddsService.getMatchOddById(id));
    }

    @PostMapping("/{matchId}")
    public ResponseEntity<MatchOdds> createMatchOdds(@RequestBody MatchOdds matchOdds,@PathVariable Long matchId){
        return ResponseEntity.ok(matchOddsService.createMatchOdds(matchOdds,matchId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MatchOdds> updateMatchOdds(@RequestBody MatchOdds updatedMatchOdds,@PathVariable Long id){
        return ResponseEntity.ok(matchOddsService.updateMatchOdds(updatedMatchOdds,id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMatchOdds(@PathVariable Long id){
        matchOddsService.deleteMatchOdds(id);
        return ResponseEntity.noContent().build();
    }
}
