package orderservice.domain.service;

import orderservice.domain.data.ShoppingCartDto;
import orderservice.domain.data.ShoppingOrderDto;
import orderservice.domain.ports.api.ShoppingOrderServicePort;
import orderservice.domain.ports.spi.ShoppingOrderPersistencePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ShoppingOrderServiceImpl implements ShoppingOrderServicePort {

    @Autowired
    private ShoppingOrderPersistencePort persistencePort;

    @Override
    public ShoppingOrderDto createShoppingOrder(long orderId, ShoppingCartDto dtoModel) {
        ShoppingOrderDto order= new ShoppingOrderDto();
        order.setId(orderId);
        order.setOrderLines(dtoModel.getProducts());
        order.setCustomer(dtoModel.getCustomer());
        order.setDescription("Order Placement");
        order.setStatus("Order Placement");
        order.setGrossValue(dtoModel.getProducts().stream().map(x->x.getQuantity()*x.getPrice()).reduce(0.0,Double::sum));
        order.setTaxValue(dtoModel.getProducts().stream().filter(x->x.getTaxable()!=null && x.getTaxable()==true).map(x->x.getQuantity()*x.getPrice()*0.07).reduce(0.0,Double::sum));
        order.setDiscountValue(dtoModel.getProducts().stream().map(x->x.getQuantity()*x.getPrice()*x.getApplicableDiscount()/100.0).reduce(0.0,Double::sum));
        order.setNetValue(order.getGrossValue()+order.getTaxValue()-order.getDiscountValue());
        ShoppingOrderDto ShoppingOrderDTO=persistencePort.createShoppingOrder(order);
        return ShoppingOrderDTO;
    }

    @Override
    public void deleteShoppingOrderById(long id) {
        persistencePort.deleteShoppingOrderById(id);
    }

    @Override
    public ShoppingOrderDto updateShoppingOrder(ShoppingOrderDto dtoModel) {
        return persistencePort.updateShoppingOrder(dtoModel);
    }

    @Override
    public List<ShoppingOrderDto> getShoppingOrders() {
        return persistencePort.getShoppingOrders();
    }

    @Override
    public ShoppingOrderDto getShoppingOrderById(long id) {
        return persistencePort.getShoppingOrderById(id);
    }
}
