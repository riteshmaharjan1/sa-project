package shoppingcartservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import shoppingcartservice.service.ShoppingCartService;

@RestController
public class ShoppingCartController {

    @Autowired
    private ShoppingCartService shoppingCartService;

    @GetMapping
    public ResponseEntity<?> getShoppingCart(int customerId) {
        return new ResponseEntity<>(shoppingCartService.getShoppingCart(customerId), HttpStatus.OK);
    }
}
