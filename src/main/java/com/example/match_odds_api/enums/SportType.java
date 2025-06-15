package com.example.match_odds_api.enums;

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
}
