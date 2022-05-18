package orderservice.infrastructure.entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Product {
    private long id;
    private String productNumber;
    private String name;
    private double price;
    private Boolean taxable;
    private double applicableDiscount;
    private String description;
    private int quantity;
    private String status;
}
