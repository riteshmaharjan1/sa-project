package shoppingcartservice.domain.ports.api;

import shoppingcartservice.domain.data.ProductDto;
import shoppingcartservice.domain.data.ShoppingCartDto;

import java.util.List;

public interface ShoppingCartServicePort {
    ShoppingCartDto addShoppingCart(ShoppingCartDto dtoModel);

    ShoppingCartDto addProduct(long cartId, ProductDto dtoModel);

    ShoppingCartDto removeProduct(long cartId, ProductDto dtoModel);

    ShoppingCartDto updateProduct(long cartId, ProductDto dtoModel);

    void deleteShoppingCartById(long id);

    ShoppingCartDto updateShoppingCart(ShoppingCartDto dtoModel);

    List<ShoppingCartDto> getShoppingCarts();

    ShoppingCartDto getShoppingCartById(long id);
}
