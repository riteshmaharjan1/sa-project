package customerservice.controller;

import customerservice.domain.dto.CustomerDto;
import customerservice.repository.dbsequence.SequenceGeneratorService;
import customerservice.service.serviceinterface.CustomerServicePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerServicePort servicePort;

    private SequenceGeneratorService sequenceGenerator;

    @Autowired
    public CustomerController(SequenceGeneratorService sequenceGenerator) {
        this.sequenceGenerator = sequenceGenerator;
    }

    @PostMapping("/add")
    public CustomerDto create(@RequestBody CustomerDto dtoModel) {
        if (!sequenceGenerator.checkIfExist(dtoModel.getId(), "customer_sequence"))
            dtoModel.setId(sequenceGenerator.generateSequence("customer_sequence"));
        return servicePort.addCustomer(dtoModel);
    }

    @PutMapping("/update")
    public CustomerDto update(@RequestBody CustomerDto CustomerDto) {
        return servicePort.addCustomer(CustomerDto);
    }

    @DeleteMapping("/remove/{id}")
    public void delete(@PathVariable long id) {
        servicePort.deleteCustomerById(id);
    }

    @GetMapping("/list")
    public List<CustomerDto> gets() {
        return servicePort.getCustomers();
    }

    @GetMapping("/view/{id}")
    public CustomerDto get(@PathVariable long id) {
        return servicePort.getCustomerById(id);
    }
}
