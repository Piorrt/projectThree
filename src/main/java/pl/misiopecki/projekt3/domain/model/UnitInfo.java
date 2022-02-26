package pl.misiopecki.projekt3.domain.model;

import lombok.Builder;
import lombok.Data;

import java.util.Map;

@Builder
@Data
public class UnitInfo {

    String name;
    Map<String, Integer> cost;
    Integer buildTime;
    Integer attack;
    Integer hitPoints;

}