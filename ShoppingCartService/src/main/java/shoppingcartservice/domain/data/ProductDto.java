package shoppingcartservice.domain.data;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProductDto {
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