package shoppingcartservice.pojo;

public class Product {

    private int productNumber;
    private String productName;
    private int quantity;

    private double price;
    private String description;

    public Product() {
    }

    public Product(int productNumber, String productName, int stockNumber, double price, String description) {
        this.productNumber = productNumber;
        this.productName = productName;
        this.quantity = stockNumber;
        this.price = price;
        this.description = description;
    }

    public Product(String productName, int stockNumber, double price, String description) {
        this.productName = productName;
        this.quantity = stockNumber;
        this.price = price;
        this.description = description;
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
}