package customerservice.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;

/**
 * Added BY rajendramaharjan
 *
 * @Codeaxis Technology Pvt. Ltd.
 * DATE:  17/05/2022 - 10:50 PM
 * PROJECT: CustomerService
 */
public class KafkaConfig {
    @Bean
    public NewTopic topicAdded() {
        return new NewTopic(TopicTermino.ADDED.getValue(), 1, (short) 1);
    }

    @Bean
    public NewTopic topicUpdated() {
        return new NewTopic(TopicTermino.UPDATED.getValue(), 1, (short) 1);
    }

    @Bean
    public NewTopic topicDeleted() {
        return new NewTopic(TopicTermino.DELETED.getValue(), 1, (short) 1);
    }

}
