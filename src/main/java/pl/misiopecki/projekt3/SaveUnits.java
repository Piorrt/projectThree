package pl.misiopecki.projekt3;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import pl.misiopecki.projekt3.domain.model.Army;
import pl.misiopecki.projekt3.domain.UnitRepository;

import java.io.File;
import java.io.IOException;

@Component
public class SaveUnits implements CommandLineRunner {

    private final ObjectMapper objectMapper;
    private final UnitRepository repository;

    public SaveUnits(ObjectMapper objectMapper, UnitRepository repository) {
        this.objectMapper = objectMapper;
        this.repository = repository;
    }

    @Override
    public void run(String... args) {
        Army army;
        try {
            army = objectMapper.readValue(readDataFile(), Army.class);
            army.getUnits().forEach(repository::save);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private File readDataFile() throws IOException {
        return new ClassPathResource(
            "data/units.json").getFile();
    }
}