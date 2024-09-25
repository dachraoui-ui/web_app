package ahmed.io.runnerz.user;

import org.springframework.boot.autoconfigure.amqp.RabbitConnectionDetails;

import java.awt.print.PrinterGraphics;

public record User(
        Integer id,
        String name,
        String username,
        String email,
        Address address,
        String phone,
        String website,
        Company company
) {
}
