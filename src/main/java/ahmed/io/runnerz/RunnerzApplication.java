package ahmed.io.runnerz;

import ahmed.io.runnerz.run.Location;
import ahmed.io.runnerz.run.Run;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.tools.JavaFileManager;
import java.time.LocalDateTime;


@SpringBootApplication
public class RunnerzApplication {

    private static final Logger log =  LoggerFactory.getLogger(RunnerzApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(RunnerzApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(){
        return args -> {
            Run run = new Run(1, "Morning Run", LocalDateTime.now(), LocalDateTime.now().plusHours(1), 5, Location.OUTDOOR);
            log.info(run.toString());
        };
    }


}
