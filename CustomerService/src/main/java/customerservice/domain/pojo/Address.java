package customerservice.domain.pojo;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Address {
    private String street;
    private String city;
    private String zip;
}