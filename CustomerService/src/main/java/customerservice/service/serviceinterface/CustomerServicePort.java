package customerservice.service.serviceinterface;

import customerservice.domain.dto.CustomerDto;

import java.util.List;

public interface CustomerServicePort {
    CustomerDto addCustomer(CustomerDto dtoModel);

    void deleteCustomerById(long id);

    CustomerDto updateCustomer(CustomerDto dtoModel);

    List<CustomerDto> getCustomers();

    CustomerDto getCustomerById(long id);

}
