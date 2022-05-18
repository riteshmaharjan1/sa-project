package customerservice.service.mappers;

import customerservice.domain.pojo.Customer;
import customerservice.domain.dto.CustomerDto;

import java.util.List;

public interface CustomerMapper {
    CustomerDto CustomerToCustomerDto(Customer Customer);

    Customer CustomerDtoToCustomer(CustomerDto CustomerDto);

    List<CustomerDto> CustomerListToCustomerDtoList(List<Customer> CustomerList);

    List<Customer> CustomerDtoListToCustomerList(List<CustomerDto> CustomerDtoList);
}
