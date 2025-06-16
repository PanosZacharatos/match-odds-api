package com.example.match_odds_api.service;

import com.example.match_odds_api.model.Match;
import com.example.match_odds_api.repository.MatchRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchService {
    private final MatchRepository matchRepository;

    public MatchService(MatchRepository matchRepository){
        this.matchRepository = matchRepository;
    }

    public Match createMatch(Match match){
        return  matchRepository.save(match);
    }

    public List<Match> getAllMatches(){
        return matchRepository.findAll();
    }

    public Match getMatchById(Long id){
        return matchRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Match with id: " + id + " could not be found"));
    }

    public Match updateMatch(Match updatedMatch,Long id){
        if(!matchRepository.existsById(id)){
            throw new RuntimeException("Match with id: " + updatedMatch.getId() + " could not be found");
        }
        else {
            return matchRepository.save(updatedMatch);
        }
    }

    public void deleteMatch(Long id){
        if(!matchRepository.existsById(id)){
            throw new RuntimeException("Match with id: " + id + " could not be found");
        }
        else{
            matchRepository.deleteById(id);
        }
    }

}
