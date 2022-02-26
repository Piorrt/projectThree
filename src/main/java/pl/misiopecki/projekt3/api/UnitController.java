package pl.misiopecki.projekt3.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.misiopecki.projekt3.domain.UnitService;
import pl.misiopecki.projekt3.domain.model.UnitInfo;

@RestController
@RequestMapping("/units")
public class UnitController {

    private UnitService unitService;


    public UnitController(UnitService unitService) {
        this.unitService = unitService;
    }

    @GetMapping(
        consumes = "application/json",
        produces = "application/json"
    )
    public ResponseEntity<UnitInfo> getUnitInformation(
        @RequestParam(name = "name", required = false, defaultValue = "none") String name,
        @RequestParam(name = "count", required = false, defaultValue = "1") Integer count
    ) {
        System.out.println("Name ------ " + name);
        UnitInfo information = unitService.getInformation(name, count);
        if (information == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(information);
    }
}