package shoppingcartviewer;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.kafka.annotation.EnableKafka;

@EnableDiscoveryClient
@SpringBootApplication
@EnableKafka
public class ShoppingCartViewerApplication implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(ShoppingCartViewerApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Receiver is running and waiting for messages");
    }
}
