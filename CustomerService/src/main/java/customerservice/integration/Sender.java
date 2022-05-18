//package customerservice.integration;
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.stereotype.Service;
//
///**
// * Added BY rajendramaharjan
// *
// * @Codeaxis Technology Pvt. Ltd.
// * DATE:  17/05/2022 - 10:57 PM
// * PROJECT: CustomerService
// */
//@Service
//public class Sender {
//    private final KafkaTemplate kafkaTemplate;
//
//    public Sender(KafkaTemplate kafkaTemplate) {
//        this.kafkaTemplate = kafkaTemplate;
//    }
//
//    public <T> void sendData(String topic, T t) {
//        ObjectMapper objectMapper = new ObjectMapper();
//        String data = "";
//        try {
//            data = objectMapper.writeValueAsString(t);
//        } catch (JsonProcessingException e) {
//            e.printStackTrace();
//        }
//        kafkaTemplate.send(topic, data);
//    }
//
//}