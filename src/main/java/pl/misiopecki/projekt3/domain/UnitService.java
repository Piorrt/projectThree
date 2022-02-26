package pl.misiopecki.projekt3.domain;

import org.springframework.stereotype.Component;
import pl.misiopecki.projekt3.domain.model.Unit;
import pl.misiopecki.projekt3.domain.model.UnitInfo;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;


@Component
public class UnitService {

    private final UnitRepository repository;

    public UnitService(UnitRepository repository) {
        this.repository = repository;
    }

    public UnitInfo getInformation(String name, Integer count) {
        Optional<Unit> foundUnit = repository.findByName(name);
        if (foundUnit.isEmpty()) {
            return null;
        }
        Unit unit = foundUnit.get();
        System.out.println("UNIT ---- " + unit);

        UnitInfo info = UnitInfo.builder()
            .name(foundUnit.get().getName())
            .buildTime(unit.getBuild_time() * count)
            .hitPoints(unit.getHit_points() * count)
            .attack(unit.getAttack() * count)
            .cost(countCost(unit.getCost(), count))
            .build();

        System.out.println("INFO --------" + info.toString());
        return info;
    }

    private Map<String, Integer> countCost(Map<String, String> unitCost, Integer count) {
        Map<String, Integer> countedCost = new HashMap<>();

        unitCost.keySet()
            .forEach(key ->
                countedCost.put(key, Integer.parseInt(unitCost.get(key)) * count)
            );

        return countedCost;
    }
}