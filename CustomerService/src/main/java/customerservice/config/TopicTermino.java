package customerservice.config;

/**
 * Added BY rajendramaharjan
 *
 * @Codeaxis Technology Pvt. Ltd.
 * DATE:  17/05/2022 - 5:08 PM
 * PROJECT: CustomerService
 */
public enum TopicTermino {
    ADDED("CUSTOMER_ADDED"), UPDATED("CUSTOMER_UPDATED"), DELETED("CUSTOMER_DELETED");

    String value;

    TopicTermino(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
