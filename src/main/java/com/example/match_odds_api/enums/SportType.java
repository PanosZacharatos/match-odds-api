package com.example.match_odds_api.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum SportType {
    Football(1),
    Basketball(2);

    @JsonValue
    private Integer value;

    SportType(Integer value){
        this.value = value;
    }

    public Integer getValue(){
        return value;
    }

    @JsonCreator
    public static SportType valueFromSport(Integer value){
        for(SportType type: SportType.values()){
            if(type.value == value){
                return type;
            }
        }
        throw new IllegalArgumentException(value +" does not exist");
    }
}
