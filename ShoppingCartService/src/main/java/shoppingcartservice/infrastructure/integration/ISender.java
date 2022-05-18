package shoppingcartservice.infrastructure.integration;

import com.fasterxml.jackson.core.JsonProcessingException;
import shoppingcartservice.domain.data.ShoppingCartDto;

public interface ISender {
    String stringObject(ShoppingCartDto shoppingDto) throws JsonProcessingException;
    void send(String topic, String cartDto);
}
