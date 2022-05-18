package shoppingcartservice.domain.ports.spi;

import shoppingcartservice.domain.data.ShoppingCartDto;

import java.util.List;

public interface ShoppingCartPersistencePort {
    ShoppingCartDto addShoppingCart(ShoppingCartDto dtoModel);

    void deleteShoppingCartById(long id);

    ShoppingCartDto updateShoppingCart(ShoppingCartDto dtoModel);

    List<ShoppingCartDto> getShoppingCarts();

    ShoppingCartDto getShoppingCartById(long id);
}
