package customerservice.service;

import customerservice.pojo.Customer;

import java.util.List;

public interface CustomerServiceInterface {
    Customer getCustomer(int customerNumber);

    List<Customer> getAllCustomer();

    void updateCustomer(Customer c);

    void deleteCustomer(Customer c);

    void insertCustomer(Customer cystomer);
}
