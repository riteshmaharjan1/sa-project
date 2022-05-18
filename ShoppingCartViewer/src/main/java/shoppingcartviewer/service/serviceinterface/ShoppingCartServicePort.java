package shoppingcartviewer.service.serviceinterface;

import shoppingcartviewer.domain.dto.ProductDTO;
import shoppingcartviewer.domain.dto.ShoppingCartDTO;

import java.util.List;

public interface ShoppingCartServicePort {
    ShoppingCartDTO addShoppingCart(ShoppingCartDTO dtoModel);

    ShoppingCartDTO addProduct(long cartId, ProductDTO dtoModel);

    ShoppingCartDTO removeProduct(long cartId, ProductDTO dtoModel);

    ShoppingCartDTO updateProduct(long cartId, ProductDTO dtoModel);

    void deleteShoppingCartById(long id);

    ShoppingCartDTO updateShoppingCart(ShoppingCartDTO dtoModel);

    List<ShoppingCartDTO> getShoppingCarts();

    ShoppingCartDTO getShoppingCartById(long id);
}
