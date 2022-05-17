package customerservice.service;

import customerservice.pojo.Customer;
import customerservice.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService implements CustomerServiceInterface {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer getCustomer(Integer customerNumber) {
        Optional<Customer> searchResult = customerRepository.findById(customerNumber);
        if (searchResult.isPresent())
            return searchResult.get();
        else {
            System.out.println("Unable to find Customer");
            return null;
        }
    }

    @Override
    public List<Customer> getAllCustomer() {
        return customerRepository.findAll();
    }

    @Override
    public Customer updateCustomer(Customer c) {
        if (customerExists(c.getCustomerId())) {
            return customerRepository.save(c);
        } else {
            return null;
        }
    }

    @Override
    public void deleteCustomer(Integer customerId) {
            customerRepository.deleteById(customerId);
    }

    @Override
    public Customer insertCustomer(Customer customer) {
        if (customerExists(customer.getCustomerId())) {
            return null;
        } else {
            return customerRepository.save(customer);
        }
    }

    @Override
    public boolean customerExists(Integer customerId) {
        return customerRepository.existsById(customerId);
    }
}
