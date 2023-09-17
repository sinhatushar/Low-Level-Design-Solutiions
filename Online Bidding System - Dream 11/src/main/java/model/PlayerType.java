package model;

import lombok.ToString;

@ToString
public enum PlayerType {
    WICKET_KEEPER,
    FAST_BOWLER,
    SPINNER,
    BATSMAN // But not a wicket keeper
}
