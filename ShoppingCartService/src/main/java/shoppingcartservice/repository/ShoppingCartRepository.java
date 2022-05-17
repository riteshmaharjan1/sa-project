package shoppingcartservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import shoppingcartservice.pojo.ShoppingCart;

public interface ShoppingCartRepository extends MongoRepository<ShoppingCart, Integer> {
}
