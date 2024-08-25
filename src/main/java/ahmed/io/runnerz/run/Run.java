package ahmed.io.runnerz.run;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;

import java.time.LocalDateTime;

public record Run(
        Integer id,
        @NotEmpty(message = "Title is required")
        String title,
        LocalDateTime startedOn,
        LocalDateTime completedOn,
        @Positive(message = "Miles must be greater than 0")
        Integer miles,
        Location location
) {
    public Run {
        if(!completedOn.isAfter(startedOn)){
            throw new IllegalArgumentException("Started on must be before completed on");
        }
    }
}
