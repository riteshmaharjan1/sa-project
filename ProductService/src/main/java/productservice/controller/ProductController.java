package productservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import productservice.pojo.Product;
import productservice.service.ProductService;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/getProduct/{productNumber}")
    public ResponseEntity<?> getProduct(@PathVariable int productNumber) {
        Product example = productService.getProduct(productNumber);
        return new ResponseEntity<>(example, HttpStatus.OK);
    }

    @PostMapping("/addProduct")
    public ResponseEntity<?> addProduct(@RequestBody Product product) {
        productService.insertProduct(product);
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }

    @PostMapping("/editProduct")
    public ResponseEntity<?> editProduct(@RequestBody Product product) {
        productService.updateProduct(product);
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }

    @PostMapping("/deleteProduct")
    public ResponseEntity<?> deleteProduct(@RequestBody Product product) {
        productService.deleteProduct(product);
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }

    @GetMapping("/getAllProducts")
    public ResponseEntity<?> getAllProducts() {
        return new ResponseEntity<>(productService.getAllProduct(), HttpStatus.OK);
    }
}
