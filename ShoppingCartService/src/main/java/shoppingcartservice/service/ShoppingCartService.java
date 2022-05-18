package shoppingcartservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shoppingcartservice.domain.data.ProductDto;
import shoppingcartservice.domain.data.ShoppingCartDto;
import shoppingcartservice.domain.ports.api.ShoppingCartServicePort;
import shoppingcartservice.domain.ports.spi.ShoppingCartPersistencePort;
import shoppingcartservice.pojo.Product;
import shoppingcartservice.pojo.ShoppingCart;
import shoppingcartservice.repository.ShoppingCartRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ShoppingCartService implements ShoppingCartServicePort {

    @Autowired
    private ShoppingCartPersistencePort persistencePort;

    @Override
    public ShoppingCartDto addShoppingCart(ShoppingCartDto dtoModel) {
        ShoppingCartDto ShoppingCartDTO=persistencePort.addShoppingCart(dtoModel);
        return ShoppingCartDTO;
    }

    @Override
    public ShoppingCartDto addProduct(long cartId, ProductDto dtoModel){
        ShoppingCartDto cartModel = persistencePort.getShoppingCartById(cartId);
        cartModel.addProduct(dtoModel);
        return persistencePort.updateShoppingCart(cartModel);
    }

    @Override
    public ShoppingCartDto removeProduct(long cartId, ProductDto dtoModel){
        ShoppingCartDto cartModel = persistencePort.getShoppingCartById(cartId);
        cartModel.removeProduct(dtoModel);
        return persistencePort.updateShoppingCart(cartModel);
    }

    @Override
    public ShoppingCartDto updateProduct(long cartId, ProductDto dtoModel){
        ShoppingCartDto cartModel = persistencePort.getShoppingCartById(cartId);
        cartModel.updateProduct(dtoModel);
        return persistencePort.updateShoppingCart(cartModel);
    }

    @Override
    public void deleteShoppingCartById(long id) {
        persistencePort.deleteShoppingCartById(id);
    }

    @Override
    public ShoppingCartDto updateShoppingCart(ShoppingCartDto dtoModel) {
        return persistencePort.updateShoppingCart(dtoModel);
    }

    @Override
    public List<ShoppingCartDto> getShoppingCarts() {
        return persistencePort.getShoppingCarts();
    }

    @Override
    public ShoppingCartDto getShoppingCartById(long id) {
        return persistencePort.getShoppingCartById(id);
    }
}
