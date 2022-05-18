package orderservice.domain.ports.spi;


import orderservice.domain.data.ShoppingOrderDto;

import java.util.List;

public interface ShoppingOrderPersistencePort {
    ShoppingOrderDto createShoppingOrder(ShoppingOrderDto dtoModel);

    void deleteShoppingOrderById(long id);

    ShoppingOrderDto updateShoppingOrder(ShoppingOrderDto dtoModel);

    List<ShoppingOrderDto> getShoppingOrders();

    ShoppingOrderDto getShoppingOrderById(long id);
}
