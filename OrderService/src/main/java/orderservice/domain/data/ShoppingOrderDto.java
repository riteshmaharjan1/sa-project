package orderservice.domain.data;

import lombok.*;
import orderservice.infrastructure.entity.Address;
import orderservice.infrastructure.entity.PaymentInfo;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ShoppingOrderDto {
    private long id;
    private CustomerDto customer;
    private List<ProductDto> orderLines;
    private int totalQuantity;
    private double grossValue;
    private double taxValue;
    private double discountValue;
    private double netValue;
    private Address billingAddress;
    private Address shippingAddress;
    private PaymentInfo paymentInfo;
    private String description;
    private String status;
}