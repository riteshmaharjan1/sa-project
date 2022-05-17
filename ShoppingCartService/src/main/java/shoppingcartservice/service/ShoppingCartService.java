package shoppingcartservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shoppingcartservice.pojo.Product;
import shoppingcartservice.pojo.ShoppingCart;
import shoppingcartservice.repository.ShoppingCartRepository;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class ShoppingCartService implements ShoppingCartServiceInterface {

    @Autowired
    private ShoppingCartRepository repository;


    @Override
    public ShoppingCart createShoppingCart(int customerId) {
        ShoppingCart shoppingCart = new ShoppingCart(new ArrayList<>());
        shoppingCart.setShoppingCartNumber(customerId);
        setShoppingCart(shoppingCart);
        return shoppingCart;
    }

    @Override
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
        shoppingCart.ifPresent(cart -> {
            cart.getProducts().remove(product);

            repository.deleteById(customerId);
            repository.insert(shoppingCart.get());
        });
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

            repository.deleteById(customerId);
            repository.insert(shoppingCart.get());
        });
    }

    @Override
    public void updateQuantity(Product product, int quantity, int customerId) {
        Optional<ShoppingCart> shoppingCart = repository.findById(customerId);
        shoppingCart.ifPresent(cart -> {
            int lastIndex = cart.getProducts().indexOf(product);
            if (lastIndex == -1) {
                cart.addProduct(product);
            } else
                cart.getProducts().get(lastIndex).setQuantity(quantity);

            repository.deleteById(customerId);
            repository.insert(cart);
        });
    }

    @Override
    public int getProductCount(Integer customerId) {
        Optional<ShoppingCart> shoppingCart = repository.findById(customerId);
        return shoppingCart.map(ShoppingCart::getProductCount).orElse(0);
    }
}
