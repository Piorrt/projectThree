package pl.misiopecki.projekt3.domain;

import org.springframework.stereotype.Component;
import pl.misiopecki.projekt3.domain.model.UnitInfo;

import java.util.HashMap;
import java.util.Map;


@Component
public class UnitService {

    private final UnitRepository repository;

    public UnitService(UnitRepository repository) {
        this.repository = repository;
    }

    public UnitInfo getInformation(String name, Integer count) {
        return repository.findByName(name)
            .map(unit ->
                UnitInfo.builder()
                    .name(unit.getName())
                    .numberOfUnit(count)
                    .buildTime(unit.getBuild_time() * count)
                    .hitPoints(unit.getHit_points() * count)
                    .attack(unit.getAttack() * count)
                    .cost(countCost(unit.getCost(), count))
                    .build()
            )
            .orElseThrow(() -> new UnitNotFoundException("Unit " + name + " not found"));
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