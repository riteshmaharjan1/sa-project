package shoppingcartviewer.integration.integrationinterface;


import shoppingcartviewer.domain.dto.ShoppingCartDTO;

import java.util.List;

public interface ShoppingCartPersistencePort {
    ShoppingCartDTO addShoppingCart(ShoppingCartDTO dtoModel);

    void deleteShoppingCartById(long id);

    ShoppingCartDTO updateShoppingCart(ShoppingCartDTO dtoModel);

    List<ShoppingCartDTO> getShoppingCarts();

    ShoppingCartDTO getShoppingCartById(long id);
}
