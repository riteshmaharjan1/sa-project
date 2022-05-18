package shoppingcartservice.infrastructure.mappers;

import org.modelmapper.ModelMapper;
import shoppingcartservice.domain.data.ShoppingCartDto;
import shoppingcartservice.infrastructure.entity.ShoppingCart;

import java.util.List;
import java.util.stream.Collectors;

public class ShoppingCartMapperImpl implements ShoppingCartMapper {

    @Override
    public ShoppingCartDto ShoppingCartToShoppingCartDto(ShoppingCart ShoppingCart) {
        ModelMapper mapper = new ModelMapper();
        ShoppingCartDto dto = mapper.map(ShoppingCart, ShoppingCartDto.class);
        return dto;
    }

    @Override
    public ShoppingCart ShoppingCartDtoToShoppingCart(ShoppingCartDto ShoppingCartDto) {
        ModelMapper mapper = new ModelMapper();
        return mapper.map(ShoppingCartDto, ShoppingCart.class);
    }

    @Override
    public List<ShoppingCartDto> ShoppingCartListToShoppingCartDtoList(List<ShoppingCart> ShoppingCartList) {
        return ShoppingCartList.stream().map(ShoppingCart -> ShoppingCartToShoppingCartDto(ShoppingCart)).collect(Collectors.toList());
    }

    @Override
    public List<ShoppingCart> ShoppingCartDtoListToShoppingCartList(List<ShoppingCartDto> ShoppingCartDtoList) {
        return ShoppingCartDtoList.stream().map(ShoppingCartDto -> ShoppingCartDtoToShoppingCart(ShoppingCartDto)).collect(Collectors.toList());
    }
}
