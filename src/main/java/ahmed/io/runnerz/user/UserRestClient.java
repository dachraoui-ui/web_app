package ahmed.io.runnerz.user;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.util.List;

@Component
public class UserRestClient {
    private final RestClient restClient;

    public UserRestClient(RestClient.Builder builder) {
        this.restClient = builder
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .build();
    }
    public List<User> findAll() {
        return this.restClient.get()
                .uri("/users")
                .retrieve()
                .body(new ParameterizedTypeReference<List<User>>() {});
    }
    public List<User> findById(int id){
        return this.restClient.get()
                .uri("/users/{id}", id)
                .retrieve()
                .body(new ParameterizedTypeReference<List<User>>() {});
    }
}
