package ahmed.io.runnerz.run;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository

public class RunRepository {
    private List<Run> runs = new ArrayList<>();

    List<Run> findAll() {
        return runs;
    }

    Optional<Run> findById(Integer id) {
        return runs.stream().filter(run -> run.id().equals(id)).findFirst();
    }

    void create(Run run) {
        runs.add(run);
    }

    @PostConstruct
    public void init() {
        runs.add(new Run(1, "Morning Run", LocalDateTime.now(), null, 5, Location.OUTDOOR));
        runs.add(new Run(2, "Evening Run", null, LocalDateTime.now().plusHours(1), 10,Location.INDOOR));
        runs.add(new Run(3, "Afternoon Run", LocalDateTime.now(), LocalDateTime.now().plusHours(2), 15, Location.OUTDOOR));
    }
}
