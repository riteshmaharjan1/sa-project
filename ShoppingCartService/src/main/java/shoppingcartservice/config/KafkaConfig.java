package shoppingcartservice.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;

/**
 * Added BY rajendramaharjan
 *
 * @Codeaxis Technology Pvt. Ltd.
 * DATE:  18/05/2022 - 8:28 AM
 * PROJECT: ShoppingCartService
 */
public class KafkaConfig {
    @Bean
    public NewTopic topicShoppingCart() {
        return new NewTopic("SHOPPINGCART_ADD", 1, (short) 1);
    }
}
