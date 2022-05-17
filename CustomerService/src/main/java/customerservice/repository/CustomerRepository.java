package customerservice.repository;

import customerservice.pojo.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Objects;

@Repository
public interface CustomerRepository extends MongoRepository<Customer, Integer> {
}
