package orderservice.infrastructure.repository;

import orderservice.infrastructure.entity.ShoppingOrder;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IShoppingOrderRepository extends MongoRepository<ShoppingOrder, Long> {
//    @Query("{accountNumber : ?0}")
//    Optional<Customer> findByAccount(String accountNumber);
}
