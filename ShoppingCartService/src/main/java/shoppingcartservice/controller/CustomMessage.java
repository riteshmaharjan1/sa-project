package shoppingcartservice.controller;

/**
 * Added BY rajendramaharjan
 *
 * @Codeaxis Technology Pvt. Ltd.
 * DATE:  17/05/2022 - 4:29 PM
 * PROJECT: CustomerService
 */
public class CustomMessage {
    String message;

    public CustomMessage(String message) {
        this.message = message;
    }

    public CustomMessage() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
