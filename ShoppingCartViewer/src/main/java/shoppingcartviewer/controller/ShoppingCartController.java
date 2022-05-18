package shoppingcartviewer.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import shoppingcartviewer.domain.dto.ShoppingCartDTO;
import shoppingcartviewer.service.serviceinterface.ShoppingCartServicePort;

import java.util.List;

@RestController
@RequestMapping("/shoppingcartviewer")
public class ShoppingCartController {
    @Autowired
    private ShoppingCartServicePort servicePort;

    @GetMapping("/list")
    public List<ShoppingCartDTO> gets() throws JsonProcessingException {
        return servicePort.getShoppingCarts();
    }

    @GetMapping("/view/{id}")
    public ShoppingCartDTO get(@PathVariable long id) throws JsonProcessingException {
        return servicePort.getShoppingCartById(id);
    }
}
