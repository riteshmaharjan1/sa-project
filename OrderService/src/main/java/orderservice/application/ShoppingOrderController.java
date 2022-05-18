package orderservice.application;

import orderservice.domain.data.ShoppingCartDto;
import orderservice.domain.data.ShoppingOrderDto;
import orderservice.domain.ports.api.ShoppingOrderServicePort;
import orderservice.infrastructure.utility.SequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class ShoppingOrderController {
    @Autowired
    private ShoppingOrderServicePort servicePort;

    private SequenceGeneratorService sequenceGenerator;

    @Autowired
    public ShoppingOrderController(SequenceGeneratorService sequenceGenerator)
    {
        this.sequenceGenerator=sequenceGenerator;
    }

    @PostMapping("/create")
    public ShoppingOrderDto create(@RequestBody ShoppingCartDto dtoModel) {
        return servicePort.createShoppingOrder(sequenceGenerator.generateSequence("ShoppingOrder_sequence"),dtoModel);
    }


    @GetMapping("/view/{id}")
    public ShoppingOrderDto get(@PathVariable long id) {
        return servicePort.getShoppingOrderById(id);
    }
}
