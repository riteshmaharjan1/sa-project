//package shoppingcartservice.listener;
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.springframework.kafka.annotation.KafkaListener;
//import org.springframework.messaging.handler.annotation.Payload;
//import org.springframework.stereotype.Service;
//import shoppingcartservice.pojo.ShoppingCart;
//
///**
// * Added BY rajendramaharjan
// *
// * @Codeaxis Technology Pvt. Ltd.
// * DATE:  18/05/2022 - 8:42 AM
// * PROJECT: ShoppingCartService
// */
//@Service
//public class SCListener {
//    @KafkaListener(topics = "SC_ADDED")
//    public void receiveSC(@Payload String s) {
//        ObjectMapper objectMapper = new ObjectMapper();
//        ShoppingCart received = null;
//        try {
//            received = objectMapper.readValue(s, ShoppingCart.class);
//        } catch (JsonProcessingException e) {
//            e.printStackTrace();
//        }
//        System.out.println("Received added ShoppingCart DATA: " + received);
//    }
//}
