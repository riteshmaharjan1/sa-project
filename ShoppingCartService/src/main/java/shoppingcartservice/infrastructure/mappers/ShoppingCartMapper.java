package shoppingcartservice.infrastructure.mappers;


import shoppingcartservice.domain.data.ShoppingCartDto;
import shoppingcartservice.infrastructure.entity.ShoppingCart;

import java.util.List;

public interface ShoppingCartMapper {
    ShoppingCartDto ShoppingCartToShoppingCartDto(ShoppingCart ShoppingCart);

    ShoppingCart ShoppingCartDtoToShoppingCart(ShoppingCartDto ShoppingCartDto);

    List<ShoppingCartDto> ShoppingCartListToShoppingCartDtoList(List<ShoppingCart> ShoppingCartList);

    List<ShoppingCart> ShoppingCartDtoListToShoppingCartList(List<ShoppingCartDto> ShoppingCartDtoList);
}
