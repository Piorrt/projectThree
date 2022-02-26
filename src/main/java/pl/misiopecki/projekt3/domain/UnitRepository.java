package pl.misiopecki.projekt3.domain;


import pl.misiopecki.projekt3.domain.model.Unit;

import java.util.Optional;

public interface UnitRepository {

    Unit save(Unit unit);

    Optional<Unit> findByName(String name);
}