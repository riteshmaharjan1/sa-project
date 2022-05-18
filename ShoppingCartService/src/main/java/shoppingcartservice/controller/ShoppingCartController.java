package shoppingcartservice.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;
import shoppingcartservice.domain.data.ProductDto;
import shoppingcartservice.domain.data.ShoppingCartDto;
import shoppingcartservice.infrastructure.integration.ISender;
import shoppingcartservice.infrastructure.utility.SequenceGeneratorService;
import shoppingcartservice.service.ShoppingCartService;

@RestController
@RequestMapping("/shoppingcart")
public class ShoppingCartController {
    @Autowired
    private ShoppingCartService servicePort;

    @Autowired
    @Lazy
    private RestOperations restTemplate;

    @Autowired
    ISender sender;

    private SequenceGeneratorService sequenceGenerator;

    @Autowired
    public ShoppingCartController(SequenceGeneratorService sequenceGenerator) {
        this.sequenceGenerator = sequenceGenerator;
    }

    @PostMapping("/create")
    public ShoppingCartDto create(@RequestBody ShoppingCartDto dtoModel) {
        if (!sequenceGenerator.checkIfExist(dtoModel.getId(), "ShoppingCart_sequence"))
            dtoModel.setId(sequenceGenerator.generateSequence("ShoppingCart_sequence"));
        try {
            ShoppingCartDto returnCart = servicePort.addShoppingCart(dtoModel);
            sender.send("topicShoppingCart", sender.stringJSON(returnCart));
            return returnCart;
        } catch (Exception ex) {
            return null;
        }
    }

    @PutMapping("/addproduct/{cart}")
    public ShoppingCartDto addProduct(@PathVariable long cart, @RequestBody ProductDto productDto) {
        try {
            ShoppingCartDto returnCart = servicePort.addProduct(cart, productDto);
            sender.send("topicShoppingCart", sender.stringJSON(returnCart));
            return returnCart;
        } catch (Exception ex) {
            return null;
        }
    }

    @DeleteMapping("/removeproduct/{cart}")
    public ShoppingCartDto removeProduct(@PathVariable long cart, @RequestBody ProductDto productDto) {
        try {
            ShoppingCartDto returnCart = servicePort.removeProduct(cart, productDto);
            sender.send("topicShoppingCart", sender.stringJSON(returnCart));
            return returnCart;
        } catch (Exception ex) {
            return null;
        }
    }

    @PutMapping("/changequantity/{cart}")
    public ShoppingCartDto changeQuantity(@PathVariable long cart, @RequestBody ProductDto productDto) {
        try {
            ShoppingCartDto returnCart = servicePort.updateProduct(cart, productDto);
            sender.send("topicShoppingCart", sender.stringJSON(returnCart));
            return returnCart;
        } catch (Exception ex) {
            return null;
        }
    }

    @GetMapping("/view/{id}")
    public ShoppingCartDto get(@PathVariable long id) throws JsonProcessingException {
        try {
            ShoppingCartDto returnCart = servicePort.getShoppingCartById(id);
            sender.send("topicShoppingCart", sender.stringJSON(returnCart));
            return returnCart;
        } catch (Exception ex) {
            return null;
        }
    }

    @PutMapping("/checkout/{cart}")
    public String checkout(@PathVariable long cart, @RequestBody ShoppingCartDto cartDto) {
        try {
            restTemplate.postForLocation("http://localhost:8080/order/create", cartDto, ShoppingCartDto.class);
            return "Success";
        } catch (Exception ex) {
            return null;
        }
    }

    @Bean
    RestOperations restTemplate() {
        return new RestTemplate();
    }
}
