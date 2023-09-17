package model;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class Bid {
    String id;
    Team team;
    Player player;
    Integer bidAmount;
}
