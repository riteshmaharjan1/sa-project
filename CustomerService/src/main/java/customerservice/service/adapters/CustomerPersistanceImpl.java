package customerservice.service.adapters;

import customerservice.domain.pojo.Customer;
import customerservice.domain.dto.CustomerDto;
import customerservice.repository.ICustomerRepository;
import customerservice.service.mappers.CustomerMapperImpl;
import customerservice.service.serviceinterface.CustomerPersistencePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CustomerPersistanceImpl implements CustomerPersistencePort {
    @Autowired
    private ICustomerRepository repository;

    @Override
    public CustomerDto addCustomer(CustomerDto dtoModel) {
        CustomerMapperImpl CustomerMapper = new CustomerMapperImpl();
        Customer Customer = CustomerMapper.CustomerDtoToCustomer(dtoModel);
        Customer CustomerSaved = repository.save(Customer);
        return CustomerMapper.CustomerToCustomerDto(CustomerSaved);
    }

    @Override
    public void deleteCustomerById(long id) {
        Optional<Customer> Customer = repository.findById(id);
        repository.deleteById(Customer.get().getId());
    }

    @Override
    public CustomerDto updateCustomer(CustomerDto CustomerDto) {
        return addCustomer(CustomerDto);
    }

    @Override
    public List<CustomerDto> getCustomers() {
        List<Customer> CustomerList = repository.findAll();
        CustomerMapperImpl CustomerMapper = new CustomerMapperImpl();
        List<CustomerDto> CustomerDtoList = CustomerMapper.CustomerListToCustomerDtoList(CustomerList);
        return CustomerDtoList;
    }

    @Override
    public CustomerDto getCustomerById(long id) {
        CustomerMapperImpl CustomerMapper = new CustomerMapperImpl();
        Optional<Customer> Customer = repository.findById(id);
        if (Customer.isPresent()) {
            return CustomerMapper.CustomerToCustomerDto(Customer.get());
        }
        return null;
    }
}
