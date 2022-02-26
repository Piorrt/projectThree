package pl.misiopecki.projekt3.external;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.misiopecki.projekt3.domain.model.Unit;
import pl.misiopecki.projekt3.domain.UnitRepository;

@Repository
public interface JpaUnitRepository extends JpaRepository<Unit, Integer>, UnitRepository {

}