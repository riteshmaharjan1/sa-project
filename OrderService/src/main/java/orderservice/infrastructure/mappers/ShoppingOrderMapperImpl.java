package orderservice.infrastructure.mappers;

import orderservice.domain.data.ShoppingOrderDto;
import orderservice.infrastructure.entity.ShoppingOrder;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public class ShoppingOrderMapperImpl implements ShoppingOrderMapper {

    @Override
    public ShoppingOrderDto ShoppingOrderToShoppingOrderDto(ShoppingOrder ShoppingOrder) {
        ModelMapper mapper = new ModelMapper();
        ShoppingOrderDto dto = mapper.map(ShoppingOrder, ShoppingOrderDto.class);
        return dto;
    }

    @Override
    public ShoppingOrder ShoppingOrderDtoToShoppingOrder(ShoppingOrderDto ShoppingOrderDto) {
        ModelMapper mapper = new ModelMapper();
        return mapper.map(ShoppingOrderDto, ShoppingOrder.class);
    }

    @Override
    public List<ShoppingOrderDto> ShoppingOrderListToShoppingOrderDtoList(List<ShoppingOrder> ShoppingOrderList) {
        return ShoppingOrderList.stream().map(ShoppingOrder -> ShoppingOrderToShoppingOrderDto(ShoppingOrder)).collect(Collectors.toList());
    }

    @Override
    public List<ShoppingOrder> ShoppingOrderDtoListToShoppingOrderList(List<ShoppingOrderDto> ShoppingOrderDtoList) {
        return ShoppingOrderDtoList.stream().map(ShoppingOrderDto -> ShoppingOrderDtoToShoppingOrder(ShoppingOrderDto)).collect(Collectors.toList());
    }
}
