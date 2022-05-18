package orderservice.infrastructure.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Document(collection = "ShoppingOrder")
public class ShoppingOrder {
    @Transient
    public static final String SEQUENCE_NAME = "order_sequence";

    @Id
    private long id;
    private Customer customer;
    private List<Product> orderLines;
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
