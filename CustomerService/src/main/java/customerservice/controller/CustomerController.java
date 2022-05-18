package customerservice.controller;

import customerservice.pojo.Customer;
import customerservice.service.CustomerService;
import customerservice.integration.Sender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @Autowired
    Sender sender;

    @GetMapping("/customers/{customerNumber}")
    public ResponseEntity<?> getCustomer(@PathVariable("customerNumber") Integer customerNumber) {
        Customer customer = customerService.getCustomer(customerNumber);
        if (customer != null) {
            return new ResponseEntity<>(customer, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new CustomMessage("Customer not found.")
                    , HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/customers")
    public ResponseEntity<?> addCustomer(@RequestBody Customer customer) {
        Customer addCus = customerService.insertCustomer(customer);
        if (addCus != null) {
            sender.sendData("CUSTOMER_ADDED", customer);
            return new ResponseEntity<>("Success", HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new CustomMessage("Customer already exists. Unable to add customer.")
                    , HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/customers")
    public ResponseEntity<?> editCustomer(@RequestBody Customer customer) {
        Customer udpate = customerService.updateCustomer(customer);
        if (udpate != null) {
            sender.sendData("CUSTOMER_UPDATED", customer);
            return new ResponseEntity<>("Successfully updated.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new CustomMessage("Customer doesn't exists.")
                    , HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/customers/{customerId}")
    public ResponseEntity<?> deleteCustomer(@PathVariable Integer customerId) {
        if (customerService.customerExists(customerId)) {
            customerService.deleteCustomer(customerId);
            sender.sendData("CUSTOMER_DELETED", customerId);
            return new ResponseEntity<>("Successfully Deleted.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new CustomMessage("Customer doesn't exists.")
                    , HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getAllCustomers")
    public ResponseEntity<?> getAllCustomers() {
        if (customerService.getAllCustomer().size() == 0) {
            return new ResponseEntity<>(new CustomMessage("Customers not available.")
                    , HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(customerService.getAllCustomer(), HttpStatus.OK);
        }
    }
}
