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
    public Customer getCustomer(int customerNumber) {
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
    public void updateCustomer(Customer c) {
        customerRepository.insert(c);
    }

    @Override
    public void deleteCustomer(Customer c) {
        customerRepository.delete(c);
    }

    @Override
    public void insertCustomer(Customer customer) {
        customerRepository.insert(customer);
    }
}
