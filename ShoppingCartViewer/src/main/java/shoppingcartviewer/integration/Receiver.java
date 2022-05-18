package shoppingcartviewer.integration;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import shoppingcartviewer.domain.dto.ShoppingCartDTO;
import shoppingcartviewer.integration.integrationinterface.ShoppingCartPersistencePort;

@Service
public class Receiver {

    @Autowired
    ShoppingCartPersistencePort persistence;

    @KafkaListener(topics = {"topicShoppingCart"})
    public void receive(@Payload String message) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            ShoppingCartDTO cart = objectMapper.readValue(message, ShoppingCartDTO.class);
            persistence.updateShoppingCart(cart);
            System.out.println("Receiver received message= " + cart);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        System.out.println("Receiver received message= " + message);
    }

}