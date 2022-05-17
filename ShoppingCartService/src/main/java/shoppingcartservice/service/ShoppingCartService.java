package shoppingcartservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shoppingcartservice.pojo.Product;
import shoppingcartservice.pojo.ShoppingCart;
import shoppingcartservice.repository.ShoppingCartRepository;

import java.util.Optional;

@Service
public class ShoppingCartService implements ShoppingCartServiceInterface {

    @Autowired
    private ShoppingCartRepository repository;

    public void setShoppingCart(ShoppingCart shoppingCart) {
        repository.insert(shoppingCart);
    }

    @Override
    public ShoppingCart getShoppingCart(int customerId) {
        Optional<ShoppingCart> shoppingCart = repository.findById(customerId);
        return shoppingCart.orElse(null);
    }

    @Override
    public void deleteProduct(int customerId, Product product) {
        Optional<ShoppingCart> shoppingCart = repository.findById(customerId);
        shoppingCart.ifPresent(cart -> cart.getProducts().remove(product));
    }

    @Override
    public void addProduct(int customerId, Product product) {
        Optional<ShoppingCart> shoppingCart = repository.findById(customerId);
        shoppingCart.ifPresent(cart -> {
            if (cart.checkProduct(product)) {
                cart.increaseProductQuantity(product);
            } else {
                cart.addProduct(product);
            }
        });
        repository.deleteById(customerId);
        repository.insert(shoppingCart.get());
    }

    @Override
    public void updateQuantity(Product product, int quantity, int customerId) {
        Optional<ShoppingCart> shoppingCart = repository.findById(customerId);
        shoppingCart.ifPresent(cart -> cart.getProducts().get(cart.getProducts().lastIndexOf(product)).setQuantity(quantity));
    }

    @Override
    public int getProductCount(Integer customerId) {
        Optional<ShoppingCart> shoppingCart = repository.findById(customerId);
        return shoppingCart.map(ShoppingCart::getProductCount).orElse(0);
    }
}
