package productservice.controller;

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