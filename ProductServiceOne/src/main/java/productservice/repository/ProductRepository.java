package productservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import productservice.pojo.Product;

@Repository
public interface ProductRepository extends MongoRepository<Product, Integer> {
}
