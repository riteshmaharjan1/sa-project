package customerservice.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import customerservice.pojo.Customer;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/**
 * Added BY rajendramaharjan
 *
 * @Codeaxis Technology Pvt. Ltd.
 * DATE:  17/05/2022 - 10:57 PM
 * PROJECT: CustomerService
 */
@Service
public class Sender {
    private final KafkaTemplate kafkaTemplate;

    public Sender(KafkaTemplate kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendCustomer(String topic, Customer customer) {
        ObjectMapper objectMapper = new ObjectMapper();
        String data = "";
        try {
            data = objectMapper.writeValueAsString(customer);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        kafkaTemplate.send(topic, data);
    }

    public void sendDeleteID(String topic, Integer dId) {
        ObjectMapper objectMapper = new ObjectMapper();
        String data = "";
        try {
            data = objectMapper.writeValueAsString(dId);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        kafkaTemplate.send(topic, data);
    }

}