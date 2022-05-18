package clientapplication.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PaymentInfo {
    private long id;
    private String cardNumber;
    private int securityCode;
    private String holderName;
}
