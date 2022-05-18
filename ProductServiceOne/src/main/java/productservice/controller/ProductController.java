package productservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import productservice.pojo.Product;
import productservice.service.ProductService;

@RestController
@Profile("ProductOne")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/products/{productNumber}")
    public ResponseEntity<?> getProduct(@PathVariable int productNumber) {
        Product product = productService.getProduct(productNumber);
        if (product != null)
            return new ResponseEntity<>(product, HttpStatus.OK);
        else
            return new ResponseEntity<>(new CustomMessage("Product not found.")
                    , HttpStatus.NOT_FOUND);
    }

    @PostMapping("/products")
    public ResponseEntity<?> addProduct(@RequestBody Product product) {
        Product addPro = productService.insertProduct(product);
        if (addPro != null) {
            return new ResponseEntity<>("Success", HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new CustomMessage("Product already exists. Unable to add product.")
                    , HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/products")
    public ResponseEntity<?> editProduct(@RequestBody Product product) {
        Product updatedPro = productService.updateProduct(product);
        if (updatedPro != null) {
            return new ResponseEntity<>("Success", HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new CustomMessage("Product doesn't exists.")
                    , HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/products/{productNumber}")
    public ResponseEntity<?> deleteProduct(@PathVariable Integer productNumber) {
        if (productService.productExists(productNumber)) {
            productService.deleteProduct(productNumber);
            return new ResponseEntity<>("Successfully Deleted.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new CustomMessage("Product doesn't exists.")
                    , HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/products")
    public ResponseEntity<?> getAllProducts() {
        if (productService.getAllProduct().size() == 0) {
            return new ResponseEntity<>(new CustomMessage("Product not available.")
                    , HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(productService.getAllProduct(), HttpStatus.OK);
        }
    }

    //For testing purpose
    @GetMapping("/products/test")
    public int getStock() {
        return 500;
    }
}
