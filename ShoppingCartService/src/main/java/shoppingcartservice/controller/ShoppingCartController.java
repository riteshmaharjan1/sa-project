package shoppingcartservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import shoppingcartservice.pojo.Product;
import shoppingcartservice.pojo.ShoppingCart;
import shoppingcartservice.service.ShoppingCartService;

@RestController
public class ShoppingCartController {

    @Autowired
    private ShoppingCartService shoppingCartService;

    @GetMapping("/getShoppingCart/{customerId}")
    public ResponseEntity<?> getShoppingCart(@PathVariable int customerId) {
        ShoppingCart shoppingCart = shoppingCartService.getShoppingCart(customerId);
        if (shoppingCart != null)
            return new ResponseEntity<>(shoppingCart, HttpStatus.OK);
        else
            return new ResponseEntity<>(new CustomMessage("No Cart found!!")
                    , HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/createShoppingCart/{customerId}")
    public ResponseEntity<?> createShoppingCart(@PathVariable int customerId) {
        ShoppingCart shoppingCart = shoppingCartService.getShoppingCart(customerId);
        if (shoppingCart != null)
            return new ResponseEntity<>(new CustomMessage("Shopping Cart Already Exist for this user.")
                    , HttpStatus.BAD_REQUEST);
        ShoppingCart s = shoppingCartService.createShoppingCart(customerId);
        return new ResponseEntity<>(s, HttpStatus.OK);
    }

    @PostMapping("/addProduct")
    public ResponseEntity<?> addProduct(@RequestBody Product product) {
        shoppingCartService.addProduct(product.getCustomerId(), product);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @DeleteMapping("/removeProduct")
    public ResponseEntity<?> deleteProduct(@RequestBody Product product) {
        shoppingCartService.deleteProduct(product.getCustomerId(), product);
        return new ResponseEntity<>(new CustomMessage("Product Removed From Shopping Cart")
                , HttpStatus.OK);
    }

    @PutMapping("/updateQuantity")
    public ResponseEntity<?> updateQuantity(@RequestBody Product product) {
        shoppingCartService.updateQuantity(product, product.getQuantity(), product.getCustomerId());
        return new ResponseEntity<>(new CustomMessage("Quantity Updated.")
                , HttpStatus.OK);
    }
}
