package productservice.pojo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Product {
    @Id
    private int productNumber;
    private String productName;
    private int stockNumber;

    private double price;
    private String description;

    public Product() {
    }

    public Product(int productNumber, String productName, int stockNumber, double price, String description) {
        this.productNumber = productNumber;
        this.productName = productName;
        this.stockNumber = stockNumber;
        this.price = price;
        this.description = description;
    }

    public Product(String productName, int stockNumber, double price, String description) {
        this.productName = productName;
        this.stockNumber = stockNumber;
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

    public int getStockNumber() {
        return stockNumber;
    }

    public void setStockNumber(int stockNumber) {
        this.stockNumber = stockNumber;
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