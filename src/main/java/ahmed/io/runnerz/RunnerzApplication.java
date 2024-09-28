package ahmed.io.runnerz;

import ahmed.io.runnerz.user.User;
import ahmed.io.runnerz.user.UserRestClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;


@SpringBootApplication
public class RunnerzApplication {

    private static final Logger log =  LoggerFactory.getLogger(RunnerzApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(RunnerzApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(UserRestClient client){
        return args -> {
            List<User> users = client.findAll();
            System.out.println(users);
            User user = client.findById(9);
            System.out.println(user);
        };
    }


}
