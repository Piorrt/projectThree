package pl.misiopecki.projekt3.domain.model;

import lombok.Data;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;
import java.util.Map;

@Data
@Entity
public class Unit {

    @Id
    Integer id;
    String name;
    String description;
    String expansion;
    String age;
    String created_in;
    @ElementCollection
    Map<String, String> cost;
    Integer build_time;
    Integer reload_tim;
    Double attack_delay;
    Double movement_rate;
    Integer line_of_sight;
    Integer hit_points;
    String range;
    Integer attack;
    String armor;
    @ElementCollection
    List<String> attack_bonus;
    Integer search_radius;
    String accuracy;

}