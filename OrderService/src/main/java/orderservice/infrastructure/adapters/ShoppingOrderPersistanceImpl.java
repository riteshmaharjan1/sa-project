package orderservice.infrastructure.adapters;

import orderservice.domain.data.ShoppingOrderDto;
import orderservice.domain.ports.spi.ShoppingOrderPersistencePort;
import orderservice.infrastructure.entity.ShoppingOrder;
import orderservice.infrastructure.mappers.ShoppingOrderMapperImpl;
import orderservice.infrastructure.repository.IShoppingOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ShoppingOrderPersistanceImpl implements ShoppingOrderPersistencePort {
    @Autowired
    private IShoppingOrderRepository repository;

    @Override
    public ShoppingOrderDto createShoppingOrder(ShoppingOrderDto dtoModel) {
        ShoppingOrderMapperImpl ShoppingOrderMapper = new ShoppingOrderMapperImpl();
        ShoppingOrder ShoppingOrder = ShoppingOrderMapper.ShoppingOrderDtoToShoppingOrder(dtoModel);
        ShoppingOrder ShoppingOrderSaved = repository.save(ShoppingOrder);
        return ShoppingOrderMapper.ShoppingOrderToShoppingOrderDto(ShoppingOrderSaved);
    }



    @Override
    public void deleteShoppingOrderById(long id) {
        Optional<ShoppingOrder> ShoppingOrder=repository.findById(id);
        repository.deleteById(ShoppingOrder.get().getId());
    }

    @Override
    public ShoppingOrderDto updateShoppingOrder(ShoppingOrderDto ShoppingOrderDto) {

        return createShoppingOrder(ShoppingOrderDto);
    }

    @Override
    public List<ShoppingOrderDto> getShoppingOrders() {
        List<ShoppingOrder> ShoppingOrderList = repository.findAll();
        ShoppingOrderMapperImpl ShoppingOrderMapper = new ShoppingOrderMapperImpl();
        List<ShoppingOrderDto> ShoppingOrderDtoList = ShoppingOrderMapper.ShoppingOrderListToShoppingOrderDtoList(ShoppingOrderList);
        return ShoppingOrderDtoList;
    }

    @Override
    public ShoppingOrderDto getShoppingOrderById(long id) {
        ShoppingOrderMapperImpl ShoppingOrderMapper = new ShoppingOrderMapperImpl();
        Optional<ShoppingOrder> ShoppingOrder = repository.findById(id);
        if (ShoppingOrder.isPresent()) {
            return ShoppingOrderMapper.ShoppingOrderToShoppingOrderDto(ShoppingOrder.get());
        }
        return null;
    }
}
