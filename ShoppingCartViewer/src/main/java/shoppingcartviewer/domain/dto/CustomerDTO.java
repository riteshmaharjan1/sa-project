package shoppingcartviewer.domain.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CustomerDTO {
    private long id;
    private String fistName;
    private String lastName;
    private AddressDTO address;
    private String phone;
    private String email;
}