package com.example.match_odds_api.service;

import com.example.match_odds_api.model.Match;
import com.example.match_odds_api.model.MatchOdds;
import com.example.match_odds_api.repository.MatchOddsRepository;
import com.example.match_odds_api.repository.MatchRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchOddsService {
    private final MatchOddsRepository matchOddsRepository;
    private final MatchRepository matchRepository;

    public MatchOddsService(MatchOddsRepository matchOddsRepository, MatchRepository matchRepository){
        this.matchOddsRepository = matchOddsRepository;
        this.matchRepository = matchRepository;
    }

    public MatchOdds createMatchOdds(MatchOdds matchOdds,Long matchId){
        Match match = matchRepository.findById(matchId).orElseThrow(()-> new RuntimeException("Match with id: " + matchId + " could not be found"));
        matchOdds.setMatch(match);
        return matchOddsRepository.save(matchOdds);
    }

    public List<MatchOdds> getAllMatchOdds(){
        return matchOddsRepository.findAll();
    }

    public MatchOdds getMatchOddById(Long id){
        return matchOddsRepository.findById(id).orElseThrow(()->new RuntimeException("Match with id: " + id + " could not be found"));
    }

    public MatchOdds updateMatchOdds(MatchOdds updatedMatchOdds,Long id){
        if(!matchOddsRepository.existsById(id)){
            throw new RuntimeException("Match with id: " + updatedMatchOdds.getId() + " could not be found");
        }
        else{
            return matchOddsRepository.save(updatedMatchOdds);
        }

    }

    public void deleteMatchOdds(Long id){
        if(!matchOddsRepository.existsById(id)){
            throw new RuntimeException("Match with id: " + id + " could not be found");
        }
        else{
            matchOddsRepository.deleteById(id);
        }

    }
}
