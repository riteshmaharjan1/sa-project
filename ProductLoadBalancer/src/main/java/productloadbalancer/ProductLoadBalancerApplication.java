package productloadbalancer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ProductLoadBalancerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductLoadBalancerApplication.class, args);
    }

}
