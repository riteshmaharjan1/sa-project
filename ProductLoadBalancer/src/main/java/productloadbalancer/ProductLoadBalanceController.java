package productloadbalancer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("product")
public class ProductLoadBalanceController {
    @Autowired
    private LoadBalancerClient loadBalancerClient;
    private final RestTemplate restTemplate = new RestTemplate();

    @DeleteMapping("/remove/{id}")
    public void delete(@PathVariable long id) {
        restTemplate.delete(getEurkaClient2BaseUri()+"/product/remove/"+id);
    }

    @GetMapping("/list")
    public ResponseEntity<?>  gets() {
        return new ResponseEntity<ProductDto[]>(restTemplate.getForObject(getEurkaClient2BaseUri()+"/product/list"
                ,ProductDto[].class), HttpStatus.OK);
    }

    @GetMapping("/view/{id}")
    public ResponseEntity<?> get(@PathVariable long id) {
        return new ResponseEntity<ProductDto>(restTemplate.getForObject(getEurkaClient2BaseUri()+"/product/view/"+id,
                ProductDto.class), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<?> create(@RequestBody ProductDto dtoModel) {
        return new ResponseEntity<ProductDto>(restTemplate.postForObject(getEurkaClient2BaseUri()+"/product/add",
                new HttpEntity<>(dtoModel),ProductDto.class), HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody ProductDto ProductDto) {
        restTemplate.put(getEurkaClient2BaseUri()+"/product/update",
                new HttpEntity<>(ProductDto),ProductDto.class);
        return new ResponseEntity<ProductDto>
                (restTemplate.getForObject(getEurkaClient2BaseUri()+"/product/view/"+ProductDto.getId(),
                ProductDto.class), HttpStatus.OK);
    }



    private String getEurkaClient2BaseUri(){
        ServiceInstance serviceInstance =  loadBalancerClient.choose("ProductService");
        return serviceInstance.getUri().toString();
    }
}