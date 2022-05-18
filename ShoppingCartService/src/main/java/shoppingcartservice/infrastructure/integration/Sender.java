package shoppingcartservice.infrastructure.integration;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import shoppingcartservice.domain.data.ShoppingCartDto;

@Service
public class Sender implements ISender {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public String stringJSON(ShoppingCartDto shoppingDto) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(shoppingDto);
    }

    @Override
    public void send(String topic, String cartDto){
        kafkaTemplate.send(topic, cartDto);
    }
}
