package shoppingcartviewer.integration.integrationinterface;


import shoppingcartviewer.domain.dto.ShoppingCartDTO;
import shoppingcartviewer.domain.ShoppingCart;

import java.util.List;

public interface ShoppingCartMapper {
    ShoppingCartDTO ShoppingCartToShoppingCartDto(ShoppingCart ShoppingCart);

    ShoppingCart ShoppingCartDtoToShoppingCart(ShoppingCartDTO ShoppingCartDto);

    List<ShoppingCartDTO> ShoppingCartListToShoppingCartDtoList(List<ShoppingCart> ShoppingCartList);

    List<ShoppingCart> ShoppingCartDtoListToShoppingCartList(List<ShoppingCartDTO> ShoppingCartDtoList);
}
