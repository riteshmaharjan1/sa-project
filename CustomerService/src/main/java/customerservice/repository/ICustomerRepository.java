package customerservice.repository;

import customerservice.domain.pojo.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepository extends MongoRepository<Customer, Long> {
}
