package shoppingcartviewer.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import shoppingcartviewer.domain.ShoppingCart;

@Repository
public interface IShoppingCartRepository extends MongoRepository<ShoppingCart, Long> {
}
