package productservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import productservice.infrastructure.utility.SequenceGeneratorService;
import productservice.pojo.ProductDTO;
import productservice.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService servicePort;

    private SequenceGeneratorService sequenceGenerator;

    @Autowired
    public ProductController(SequenceGeneratorService sequenceGenerator) {
        this.sequenceGenerator = sequenceGenerator;
    }

    @PostMapping("/add")
    public ProductDTO create(@RequestBody ProductDTO dtoModel) {
        System.out.println("Product Service A");
        if (!sequenceGenerator.checkIfExist(dtoModel.getId(), "product_sequence"))
            dtoModel.setId(sequenceGenerator.generateSequence("product_sequence"));
        return servicePort.addProduct(dtoModel);
    }

    @PutMapping("/update")
    public ProductDTO update(@RequestBody ProductDTO ProductDto) {
        System.out.println("Product Service A");
        return servicePort.addProduct(ProductDto);
    }

    @DeleteMapping("/remove/{id}")
    public void delete(@PathVariable long id) {
        System.out.println("Product Service A");
        servicePort.deleteProductById(id);
    }

    @GetMapping("/list")
    public List<ProductDTO> gets() {
        System.out.println("Product Service A");
        return servicePort.getProducts();
    }

    @GetMapping("/view/{id}")
    public ProductDTO get(@PathVariable long id) {
        System.out.println("Product Service A");
        return servicePort.getProductById(id);
    }
}

