package ahmed.io.runnerz.run;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/runs")
public class RunController {

    private final RunRepository runRepository;

    public RunController(RunRepository runRepository) {
        this.runRepository = runRepository;
    }
    @GetMapping("")
    List<Run> findAll() {
        return runRepository.findAll();
    }
    @GetMapping("/{id}")
    Run findById(@PathVariable Integer id) {
        Optional<Run> run = runRepository.findById(id);
        if (run.isEmpty()){
            throw new RunNotFoundException();
        }
        return run.get();
    }
    //Post
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/add")
    void create(@Valid @RequestBody Run run){
        runRepository.save(run);
    }


    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/update/{id}")
    void update(@Valid @RequestBody Run run, @PathVariable Integer id){
        runRepository.save(run);
    }
    //Delete
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/delete/{id}")
    void delete(@PathVariable Integer id){
        runRepository.delete(runRepository.findById(id).get());
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @GetMapping("/location/{location}")
    List<Run> findByLocation(@PathVariable Location location){
        return runRepository.findRunByLocation(location);
    }
    // add find by location
}
