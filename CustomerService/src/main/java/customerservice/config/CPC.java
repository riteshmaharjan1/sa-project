//package customerservice.config;
//
//import org.apache.kafka.clients.admin.NewTopic;
//import org.apache.kafka.clients.producer.ProducerConfig;
//import org.apache.kafka.common.serialization.StringSerializer;
//import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.kafka.core.DefaultKafkaProducerFactory;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.kafka.core.ProducerFactory;
//import org.springframework.kafka.support.serializer.JsonSerializer;
//
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * Added BY rajendramaharjan
// *
// * @Codeaxis Technology Pvt. Ltd.
// * DATE:  17/05/2022 - 4:57 PM
// * PROJECT: CustomerService
// */
//@Configuration
//public class CustomerProducerConfig {
//
////    final KafkaProperties kafkaProperties;
////
////    public CustomerProducerConfig(KafkaProperties kafkaProperties) {
////        this.kafkaProperties = kafkaProperties;
////    }
////
////    @Bean
////    public Map<String, Object> producerConfiguration() {
////        Map<String, Object> properties = new HashMap<>(kafkaProperties.buildProducerProperties());
////        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
////        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
////        return properties;
////    }
////
////    @Bean
////    ProducerFactory<String, Object> producerFactory() {
////        return new DefaultKafkaProducerFactory<>(producerConfiguration());
////    }
////
////    @Bean
////    KafkaTemplate<String, Object> kafkaTemplate() {
////        return new KafkaTemplate<>(producerFactory());
////    }
//
//    @Bean
//    public NewTopic topicAdded() {
//        return new NewTopic(TopicTermino.ADDED.getValue(), 1, (short) 1);
//    }
//
//    @Bean
//    public NewTopic topicUpdated() {
//        return new NewTopic(TopicTermino.UPDATED.getValue(), 1, (short) 1);
//    }
//
//    @Bean
//    public NewTopic topicDeleted() {
//        return new NewTopic(TopicTermino.DELETED.getValue(), 1, (short) 1);
//    }
//
//    @Bean
//    public NewTopic tooFast() {
//        return new NewTopic("tooFastTopic", 1, (short) 1);
//    }
//}

//FROM CONTROLLER CLASS
////    final KafkaTemplate kafkaTemplate;
////public CustomerController(KafkaTemplate kk) {
////    this.kafkaTemplate = kk;
////}
//    //            send added Product in added channel
////            kafkaTemplate.send("CUSTOMER_ADDED", addCus);
