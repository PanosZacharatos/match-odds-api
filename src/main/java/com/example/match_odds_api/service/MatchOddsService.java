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
        return matchOddsRepository.findById(id).orElseThrow(()->new RuntimeException("Match odd with id: " + id + " could not be found"));
    }

    public MatchOdds updateMatchOdds(MatchOdds updatedMatchOdds,Long id, Long matchId){
        if(!matchOddsRepository.existsById(id)){
            throw new RuntimeException("Match with id: " + updatedMatchOdds.getId() + " could not be found");
        }
        else{
            Match match = matchRepository.findById(matchId).orElseThrow(()-> new RuntimeException("Match with id: " + matchId + " could not be found"));
            updatedMatchOdds.setMatch(match);
            return matchOddsRepository.save(updatedMatchOdds);
        }

    }

//    public MatchOdds updateMatchOdds(MatchOdds updatedMatchOdds,Long id){
//        if(!matchOddsRepository.existsById(id)){
//            throw new RuntimeException("Match odd with id:"  + id + " could not be found");
//        }
//
//        Long matchId = updatedMatchOdds.getMatch() != null ? updatedMatchOdds.getMatch().getId() : null;
//        if(matchId == null){
//            throw new RuntimeException("Match id is required in payload");
//        }
//        Match match = matchRepository.findById(matchId).orElseThrow(()-> new RuntimeException("Match with id: " + matchId + " could not be found"));
//        updatedMatchOdds.setId(id);
//        updatedMatchOdds.setMatch(match);
//        return matchOddsRepository.save(updatedMatchOdds);
//    }

//    public MatchOdds updateMatchOdds(MatchOdds updatedMatchOdds, Long id) {
//        System.out.println("Starting updateMatchOdds with ID: " + id);
//        System.out.println("Payload received: " + updatedMatchOdds);
//
//        if (!matchOddsRepository.existsById(id)) {
//            System.out.println("MatchOdds with id " + id + " does not exist");
//            throw new RuntimeException("Match odd with id: " + id + " could not be found");
//        }
//
//        if (updatedMatchOdds.getMatch() == null) {
//            System.out.println("Match object is null in request payload");
//            throw new RuntimeException("Match is required in payload");
//        }
//
//        Long matchId = updatedMatchOdds.getMatch().getId();
//        System.out.println("Extracted match ID: " + matchId);
//
//        if (matchId == null) {
//            System.out.println("Match ID is null in payload's match object");
//            throw new RuntimeException("Match id is required in payload");
//        }
//
//        Match match = matchRepository.findById(matchId)
//                .orElseThrow(() -> {
//                    System.out.println("Match with id " + matchId + " not found in database");
//                    return new RuntimeException("Match with id: " + matchId + " could not be found");
//                });
//
//        System.out.println("Match found: " + match);
//
//        updatedMatchOdds.setId(id);
//        updatedMatchOdds.setMatch(match);
//        System.out.println("Final MatchOdds object to be saved: " + updatedMatchOdds);
//
//        MatchOdds saved = matchOddsRepository.save(updatedMatchOdds);
//        System.out.println("MatchOdds updated and saved: " + saved);
//
//        return saved;
//    }


    public void deleteMatchOdds(Long id){
        if(!matchOddsRepository.existsById(id)){
            throw new RuntimeException("Match odd with id: " + id + " could not be found");
        }
        else{
            matchOddsRepository.deleteById(id);
        }

    }

}
