package shoppingcartviewer.domain.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AddressDTO {
    private String street;
    private String city;
    private String zip;
}