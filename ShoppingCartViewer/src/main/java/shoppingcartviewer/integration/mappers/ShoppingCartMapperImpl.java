package shoppingcartviewer.integration.mappers;

import org.modelmapper.ModelMapper;
import shoppingcartviewer.domain.dto.ShoppingCartDTO;
import shoppingcartviewer.domain.ShoppingCart;
import shoppingcartviewer.integration.integrationinterface.ShoppingCartMapper;

import java.util.List;
import java.util.stream.Collectors;

public class ShoppingCartMapperImpl implements ShoppingCartMapper {

    @Override
    public ShoppingCartDTO ShoppingCartToShoppingCartDto(ShoppingCart ShoppingCart) {
        ModelMapper mapper = new ModelMapper();
        ShoppingCartDTO dto = mapper.map(ShoppingCart, ShoppingCartDTO.class);
        return dto;
    }

    @Override
    public ShoppingCart ShoppingCartDtoToShoppingCart(ShoppingCartDTO ShoppingCartDto) {
        ModelMapper mapper = new ModelMapper();
        return mapper.map(ShoppingCartDto, ShoppingCart.class);
    }

    @Override
    public List<ShoppingCartDTO> ShoppingCartListToShoppingCartDtoList(List<ShoppingCart> ShoppingCartList) {
        return ShoppingCartList.stream().map(ShoppingCart -> ShoppingCartToShoppingCartDto(ShoppingCart)).collect(Collectors.toList());
    }

    @Override
    public List<ShoppingCart> ShoppingCartDtoListToShoppingCartList(List<ShoppingCartDTO> ShoppingCartDtoList) {
        return ShoppingCartDtoList.stream().map(ShoppingCartDto -> ShoppingCartDtoToShoppingCart(ShoppingCartDto)).collect(Collectors.toList());
    }
}
