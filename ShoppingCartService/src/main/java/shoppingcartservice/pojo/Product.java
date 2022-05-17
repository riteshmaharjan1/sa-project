package shoppingcartservice.pojo;

public class Product {

    private int productNumber;
    private String productName;
    private int quantity;

    private double price;
    private String description;

    private int customerId;

    public Product() {
    }

    public Product(int productNumber, String productName, int stockNumber, double price, String description, int customerId) {
        this.productNumber = productNumber;
        this.productName = productName;
        this.quantity = stockNumber;
        this.price = price;
        this.description = description;
        this.customerId = customerId;
    }

    public Product(String productName, int stockNumber, double price, String description, int customerId) {
        this.productName = productName;
        this.quantity = stockNumber;
        this.price = price;
        this.description = description;
        this.customerId = customerId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(int productNumber) {
        this.productNumber = productNumber;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!(obj instanceof Product product)) return false;
        return product.getProductNumber() == this.getProductNumber();
    }
}