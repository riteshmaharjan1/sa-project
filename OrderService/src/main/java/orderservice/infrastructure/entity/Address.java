package orderservice.infrastructure.entity;

import lombok.*;
import orderservice.domain.data.AddressType;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Address {
    private AddressType addressType;
    private String street;
    private String city;
    private String zip;
}