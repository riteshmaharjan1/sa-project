package customerservice.listener;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import customerservice.pojo.Customer;
import customerservice.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * Added BY rajendramaharjan
 *
 * @Codeaxis Technology Pvt. Ltd.
 * DATE:  17/05/2022 - 11:02 PM
 * PROJECT: CustomerService
 */
@Service
public class CustomerListener {

    @Autowired
    CustomerRepository customerRepository;

    @KafkaListener(topics = "CUSTOMER_ADDED")
    public void receive(@Payload String s) {
        ObjectMapper objectMapper = new ObjectMapper();
        Customer received = null;
        try {
            received = objectMapper.readValue(s, Customer.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        System.out.println("Received customer DATA: " + received);
    }
}
