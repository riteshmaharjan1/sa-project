package customerservice.service;

import customerservice.pojo.Customer;

import java.util.List;

public interface CustomerServiceInterface {
    Customer getCustomer(Integer customerNumber);

    List<Customer> getAllCustomer();

    Customer updateCustomer(Customer c);

    void deleteCustomer(Integer c);

    Customer insertCustomer(Customer cystomer);

    boolean customerExists(Integer customerId);
}
