package pl.misiopecki.projekt3.domain.model;

import lombok.Data;

import java.util.List;

@Data
public class Army {

    List<Unit> units;
}